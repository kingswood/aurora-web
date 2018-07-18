package com.volvo.aurora.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volvo.aurora.entity.ModelInfoEntity;

//@Component
public interface IModelInfoRepository extends JpaRepository<ModelInfoEntity, Integer>{

}
