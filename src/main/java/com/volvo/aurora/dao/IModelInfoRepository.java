package com.volvo.aurora.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.volvo.aurora.entity.*;

//@Component
public interface IModelInfoRepository extends JpaRepository<ModelInfoEntity, Integer>{

}
