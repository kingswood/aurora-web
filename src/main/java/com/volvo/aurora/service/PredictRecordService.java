package com.volvo.aurora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volvo.aurora.dao.IPredictRecordEntityRepository;
import com.volvo.aurora.entity.PredictRecordEntity;

@Service
public class PredictRecordService implements IPredictRecordService {

	@Autowired
	private IPredictRecordEntityRepository predictDAO;
	
	@Override
	public PredictRecordEntity PredictNewInfo(PredictRecordEntity predict) {
		// TODO Auto-generated method stub
		return predictDAO.save(predict);
	}

}
