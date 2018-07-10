package com.volvo.aurora.service;

import java.util.*;

import com.volvo.aurora.entity.*;

public interface ITrainingInfoService {

	List<TrainingInfoEntity> GetAllTrainingHistory();
	TrainingInfoEntity SaveTrainingInfo(TrainingInfoEntity trainingInfo);
	
}
