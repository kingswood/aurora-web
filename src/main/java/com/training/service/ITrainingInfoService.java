package com.training.service;

import com.training.entity.*;
import java.util.*;

public interface ITrainingInfoService {

	List<TrainingInfoEntity> GetAllTrainingHistory();
	TrainingInfoEntity SaveTrainingInfo(TrainingInfoEntity trainingInfo);
	
}
