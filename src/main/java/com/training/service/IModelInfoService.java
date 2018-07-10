package com.training.service;

import com.training.entity.*;
import java.util.*;

public interface IModelInfoService {
	
	List<ModelInfoEntity> GetAllModelInfo();
	
	HashMap<Integer, String> GetModelBrief();
	
	ModelInfoEntity CreateModel(ModelInfoEntity model);
}
