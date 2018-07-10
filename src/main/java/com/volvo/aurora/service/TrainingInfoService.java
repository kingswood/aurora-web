package com.volvo.aurora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volvo.aurora.entity.TrainingInfoEntity;
import com.volvo.aurora.repository.ITrainingInfoEntityRepository;

@Service
public class TrainingInfoService implements ITrainingInfoService {
	
	@Autowired
	private ITrainingInfoEntityRepository trainingDAO;

	public List<TrainingInfoEntity> GetAllTrainingHistory() {
		// TODO Auto-generated method stub
		List<TrainingInfoEntity> result = trainingDAO.findAll();
		return result;
	}

	public TrainingInfoEntity SaveTrainingInfo(TrainingInfoEntity trainingInfo) {
		// TODO Auto-generated method stub
		trainingInfo = trainingDAO.save(trainingInfo);
		return null;
	}

}
