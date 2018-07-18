package com.volvo.aurora.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.volvo.aurora.entity.PredictRecordEntity;

//@Component
public interface IPredictRecordEntityRepository extends JpaRepository<PredictRecordEntity, Integer> {

}
