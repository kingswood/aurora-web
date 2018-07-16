package com.volvo.aurora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volvo.aurora.dao.*;
import com.volvo.aurora.entity.TrainingInfoEntity;

@Service
public class TrainingInfoService implements ITrainingInfoService {

	@Autowired
	private ITrainingInfoEntityRepository trainingDAO;

	@Override
	public List<TrainingInfoEntity> GetAllTrainingHistory() {
		// TODO Auto-generated method stub
		List<TrainingInfoEntity> result = trainingDAO.findAll();
		return result;
	}

	@Override
	public TrainingInfoEntity SaveTrainingInfo(TrainingInfoEntity trainingInfo) {
		trainingInfo = trainingDAO.save(trainingInfo);
		return trainingInfo;
	}

}
