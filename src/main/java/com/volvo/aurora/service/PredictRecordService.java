package com.volvo.aurora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volvo.aurora.entity.PredictRecordEntity;
import com.volvo.aurora.repository.IPredictRecordEntityRepository;

@Service
public class PredictRecordService implements IPredictRecordService {

	@Autowired
	private IPredictRecordEntityRepository predictDAO;
	
	public PredictRecordEntity PredictNewInfo(String info, int modelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
