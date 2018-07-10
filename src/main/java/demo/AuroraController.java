package demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.TrainingInfoEntity;
import com.training.service.*;

@RestController
public class AuroraController {
	@Autowired
	private ITrainingInfoService trainingService;
	
	@GetMapping("/all")
	public ResponseEntity<List<TrainingInfoEntity>> getTrainingHistory() {
		try {
		List<TrainingInfoEntity> list = trainingService.GetAllTrainingHistory();
		return new ResponseEntity<List<TrainingInfoEntity>>(list,HttpStatus.OK);}
		catch(Exception ex) {
			System.out.println("test");
			return new ResponseEntity<List<TrainingInfoEntity>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}


}
