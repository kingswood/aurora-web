package com.volvo.aurora.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volvo.aurora.dao.IModelInfoRepository;
import com.volvo.aurora.entity.ModelInfoEntity;

@Service
public class ModelInfoService implements IModelInfoService {

	@Autowired
	private IModelInfoRepository modelDAO;
	
	@Override
	public List<ModelInfoEntity> GetAllModelInfo() {
		// TODO Auto-generated method stub
		return modelDAO.findAll();
	}

	@Override
	public HashMap<Integer, String> GetModelBrief() {
		// TODO Auto-generated method stub
		
		List<ModelInfoEntity> models = modelDAO.findAll();
		HashMap<Integer, String> Infos = new HashMap<Integer, String> ();
		models.forEach(model->{
			Infos.put(model.getId(), model.getModelName());
		});
		
		return Infos;
	}

	@Override
	public ModelInfoEntity CreateModel(ModelInfoEntity model) {
		// TODO Auto-generated method stub
		return modelDAO.save(model);
	}

	@Override
	public Optional<ModelInfoEntity> GetModelById(Integer id) {
		return modelDAO.findById(id);
	}
}
