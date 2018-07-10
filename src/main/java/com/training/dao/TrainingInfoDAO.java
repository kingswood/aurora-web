package com.training.dao;

import com.training.entity.*;

public class TrainingInfoDAO<TrainingInfoEntity extends BaseEntity> extends CommonDAO<BaseEntity> implements ITrainingInfoDAO<TrainingInfoEntity> {

	public TrainingInfoDAO(Class<BaseEntity> tClass) {
		super(tClass);
		// TODO Auto-generated constructor stub
	}

}
