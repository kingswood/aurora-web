package com.volvo.aurora.service;

import java.util.*;

import com.volvo.aurora.entity.*;

public interface IModelInfoService {
	
	List<ModelInfoEntity> GetAllModelInfo();
	
	HashMap<Integer, String> GetModelBrief();
	
	ModelInfoEntity CreateModel(ModelInfoEntity model);
}
