package com.training.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.training.dao.IModelInfoDAO;
import com.training.entity.ModelInfoEntity;
import com.training.repository.IModelInfoRepository;

@Service
public class ModelInfoService implements IModelInfoService {

	@Autowired
	//private IModelInfoDAO modelDAO;
	private IModelInfoRepository modelDAO;
	
	public List<ModelInfoEntity> GetAllModelInfo() {
		// TODO Auto-generated method stub
		return modelDAO.findAll();
	}

	public HashMap<Integer, String> GetModelBrief() {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelInfoEntity CreateModel(ModelInfoEntity model) {
		// TODO Auto-generated method stub
		return modelDAO.save(model);
	}

}
