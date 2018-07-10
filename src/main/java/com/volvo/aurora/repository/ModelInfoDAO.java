package com.volvo.aurora.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.volvo.aurora.entity.BaseEntity;
import com.volvo.aurora.entity.ModelInfoEntity;

@SuppressWarnings("hiding")
public class ModelInfoDAO extends CommonDAO<ModelInfoEntity>{

	public ModelInfoDAO(Class<ModelInfoEntity> tClass) {
		super(tClass);
		// TODO Auto-generated constructor stub
	} //implements IModelInfoDAO<ModelInfoEntity>{
	
	
//	
//	public ModelInfoDAO(Class<ModelInfoEntity> c){
//
//		super(c);
//		//Class<ModelInfoEntity> clazz = ModelInfoEntity.class;
//		
//	}
//	
//	public ModelInfoDAO() {
//
//	}
}
