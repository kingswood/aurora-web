package com.training.controller;

import java.util.Date;
import java.util.List;
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
import com.training.entity.*;
import com.training.service.*;

import demo.trainingdomain.traininginfo;

@RestController
public class TrainingController {

	@Autowired
	private ITrainingInfoService trainingService;

	@Autowired
	private IModelInfoService modelService;

	@Autowired
	private IPredictRecordService predictService;

	@GetMapping("/traininginfo/all")
	public ResponseEntity<List<TrainingInfoEntity>> getTrainingHistory() {
		try {
		List<TrainingInfoEntity> list = trainingService.GetAllTrainingHistory();
		return new ResponseEntity<List<TrainingInfoEntity>>(list,HttpStatus.OK);}
		catch(Exception ex) {
			System.out.println("test");
			return new ResponseEntity<List<TrainingInfoEntity>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@PostMapping("/traininginfo/training")
	public ResponseEntity<Void> addTrainingInfo(@RequestParam("file") MultipartFile file, @RequestParam("method") String method) throws IOException {
		String filePath = generateFilePath();
		
		boolean result = false;
		File folder = new File(filePath);
		if (!folder.exists()) {			
				folder.mkdir();
				//result = true;
		}
		
		InputStream in = file.getInputStream();
		
//	    File currDir = new File(".");
//	    String path = currDir.getAbsolutePath();
		
		
	    String fileLocation = filePath+"//" + file.getOriginalFilename();
	    FileOutputStream f = new FileOutputStream(fileLocation);
	    int ch = 0;
	    while ((ch = in.read()) != -1) {
	        f.write(ch);
	    }
	    f.flush();
	    f.close();

	    //1 call py, pass path to method
	    String resultPath = new String();
	    
	    //2. got result, save into DB   
	    java.sql.Date trainingDate = new java.sql.Date(new Date().getTime());
	    
	    ModelInfoEntity model = new ModelInfoEntity();
	    model.setModelName(file.getOriginalFilename());
	    model.setPath(fileLocation);
	    model.setTrainingDate(trainingDate);
	    model.setTrainingMethod(method);

	    
	    TrainingInfoEntity trainingInfo = new TrainingInfoEntity();
	    trainingInfo.setResultModel(model);
		return null;
	}

	@GetMapping("/modelinfo/all")
	public ResponseEntity<List<ModelInfoEntity>> getModelList() {
		return null;
	}

	@PostMapping("predict/predict")
	public ResponseEntity<Void> predict(@RequestBody String info, Integer modelid) {
		return null;
	}

	private String generateFilePath() {
		String path = "C:\\TestML\\";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String d = sdf.format(new Date());
		path = path + d;
		return path;
	}
}