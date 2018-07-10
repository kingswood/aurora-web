package com.training.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entity.*;

@Repository
public interface IPredictRecordEntityRepository extends JpaRepository<PredictRecordEntity, Integer> {

}
