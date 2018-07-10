package com.training.dao;

import com.training.entity.*;

public class PredictRecordDAO<PredictRecordEntity extends BaseEntity> extends CommonDAO<BaseEntity> implements IPredictRecordDAO<PredictRecordEntity> {

	public PredictRecordDAO(Class<BaseEntity> tClass) {
		super(tClass);
		// TODO Auto-generated constructor stub
	}

}
