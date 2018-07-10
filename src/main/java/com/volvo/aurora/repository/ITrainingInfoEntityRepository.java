package com.volvo.aurora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.volvo.aurora.entity.*;

@Repository
public interface ITrainingInfoEntityRepository extends JpaRepository<TrainingInfoEntity, Integer> {

}
