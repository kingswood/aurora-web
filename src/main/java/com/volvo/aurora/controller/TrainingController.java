package com.volvo.aurora.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.io.File;
import java.io.*;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.volvo.aurora.dto.PredictPara;
import com.volvo.aurora.entity.*;
import com.volvo.aurora.service.*;

@RestController
public class TrainingController {

	@Autowired
	private ITrainingInfoService trainingService;

	@Autowired
	private IModelInfoService modelService;

	@Autowired
	private IPredictRecordService predictService;

	@GetMapping("/test")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<String>("test", HttpStatus.OK);
	}

	@GetMapping("/traininginfo/all")
	public ResponseEntity<List<TrainingInfoEntity>> getTrainingHistory() {
		try {
			List<TrainingInfoEntity> list = trainingService.GetAllTrainingHistory();
			return new ResponseEntity<List<TrainingInfoEntity>>(list, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println("test");
			return new ResponseEntity<List<TrainingInfoEntity>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/traininginfo/training")
	public ResponseEntity<Void> addTrainingInfo(@RequestParam("file") MultipartFile file,
			@RequestParam("method") String method) throws IOException {
		String filePath = generateFilePath();

		boolean result = false;
		File folder = new File(filePath);
		if (!folder.exists()) {
			folder.mkdir();
			// result = true;
		}

		InputStream in = file.getInputStream();

		// File currDir = new File(".");
		// String path = currDir.getAbsolutePath();

		String fileLocation = filePath + "\\" + file.getOriginalFilename();
		FileOutputStream f = new FileOutputStream(fileLocation);
		int ch = 0;
		while ((ch = in.read()) != -1) {
			f.write(ch);
		}
		f.flush();
		f.close();

		// 1 call py, pass path to method
		String resultPath = new String();

		// 2. got result, save into DB
		java.sql.Date trainingDate = new java.sql.Date(new Date().getTime());

		ModelInfoEntity model = new ModelInfoEntity();
		model.setModelName(file.getOriginalFilename());
		model.setPath(fileLocation);
		model.setTrainingDate(trainingDate);
		model.setTrainingMethod(method);

		TrainingInfoEntity trainingInfo = new TrainingInfoEntity();
		trainingInfo.setResultModel(model);
		trainingInfo.setTrainingDate(trainingDate);

		trainingInfo = trainingService.SaveTrainingInfo(trainingInfo);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.OK);
		return response;
	}

	@GetMapping("/modelinfo/all")
	public ResponseEntity<List<ModelInfoEntity>> getModelList() {
		List<ModelInfoEntity> list = modelService.GetAllModelInfo();
		ResponseEntity<List<ModelInfoEntity>> response = new ResponseEntity<List<ModelInfoEntity>>(list, HttpStatus.OK);
		return response;
	}

	@PostMapping("predict/predict")
	public ResponseEntity<String> predict(@RequestBody PredictPara para) {

		 //Integer modelid = para.getModelId();
		Optional<ModelInfoEntity> model = modelService.GetModelById(para.getModelId());
		if (model != null) {
			String modelPath = model.get().getPath();
			String predictResult = callPy(para.Info, modelPath);

			PredictRecordEntity pe = new PredictRecordEntity();
			pe.setContent(predictResult);
			pe.setModelInfo(model.get());

			predictService.PredictNewInfo(pe);

			return new ResponseEntity(HttpStatus.OK);
		}

		return new ResponseEntity("Input Error", HttpStatus.OK);

	}

	private String generateFilePath() {
		String path = "C:\\TestML\\";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String d = sdf.format(new Date());
		path = path + d;
		return path;
	}

	private String callPy(String desc, String modelPath) {
		try {

			// String input = String.format(template, desc);
			// String[] callAndArgs= {"python","externalFile/hello2.py",desc};
			String[] callAndArgs = { "python", modelPath, desc };

			Runtime rt = Runtime.getRuntime();

			Process proc = rt.exec(callAndArgs);

			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

			// read the output from the command
			System.out.println("Here is the standard output of the command:\n");
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
				return s;
			}

			// read any errors from the attempted command
			System.out.println("Here is the standard error of the command (if any)");
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
				return s;
			}

		}

		catch (IOException e) {

			System.out.println("exception occured");

			e.printStackTrace();

			System.exit(-1);

		}

		return null;
	}
}
