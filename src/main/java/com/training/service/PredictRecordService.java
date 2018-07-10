package com.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.training.dao.IPredictRecordDAO;
import com.training.entity.PredictRecordEntity;
import com.training.repository.IPredictRecordEntityRepository;

@Service
public class PredictRecordService implements IPredictRecordService {

	@Autowired
	private IPredictRecordEntityRepository predictDAO;
	
	public PredictRecordEntity PredictNewInfo(String info, int modelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
