package com.volvo.aurora.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volvo.aurora.entity.TrainingInfoEntity;

//@Component
public interface ITrainingInfoEntityRepository extends JpaRepository<TrainingInfoEntity, Integer> {

}
