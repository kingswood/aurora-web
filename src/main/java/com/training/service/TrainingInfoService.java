package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.repository.*;
import com.training.entity.TrainingInfoEntity;

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
