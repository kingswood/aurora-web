package demo.trainingdomain;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class TraininginfoController {
	@Autowired
	private ITrainingInfoService trainingService;
	
	@GetMapping("training/{id}")
	public ResponseEntity<traininginfo> getTraininginfobyId(@PathVariable("id") Integer id){
		traininginfo info = trainingService.getTrainingById(id);
		return new ResponseEntity<traininginfo>(info, HttpStatus.OK);
	}
	
	@GetMapping("training/all")
	public ResponseEntity<List<traininginfo>> getAllTraining(){
		List<traininginfo> list = trainingService.getAllTraininginfo();
		return new ResponseEntity<List<traininginfo>>(list, HttpStatus.OK);
	}
	
	@PutMapping("training")
	public ResponseEntity<traininginfo> updateTraininginfo(@RequestBody traininginfo info){
		trainingService.updateTraininginfo(info);
		return new ResponseEntity<traininginfo>(info, HttpStatus.OK);
	}
	
	@PostMapping("training")
	public ResponseEntity<Void> addTrainingInfo(@RequestBody traininginfo info, UriComponentsBuilder builder){
		boolean flag = trainingService.addTraininginfo(info);
		if (flag == false) {
    	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
            }
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(info.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@DeleteMapping("training/{id}")
	public ResponseEntity<Void> deleteTraininginfo(@PathVariable("id") Integer id){
		trainingService.deleteTraininginfo(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
