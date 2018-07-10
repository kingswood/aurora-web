package com.volvo.aurora.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "training_info")
public class TrainingInfoEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "training_date")
	private Date trainingDate;

	@Column(name = "training_number")
	private Integer trainingSetNumber;

	@Column(name = "test_number")
	private Integer testSetNumber;

	@Column(name = "accuracy")
	private Integer accuracy;

	@Column(name = "total_number")
	private Integer totalNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "model_id")
	private ModelInfoEntity resultModel;

	public ModelInfoEntity getResultModel() {
		return resultModel;
	}

	public void setResultModel(ModelInfoEntity resultModel) {
		this.resultModel = resultModel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(Date trainingDate) {
		this.trainingDate = trainingDate;
	}

	public Integer getTrainingSetNumber() {
		return trainingSetNumber;
	}

	public void setTrainingSetNumber(Integer trainingSetNumber) {
		this.trainingSetNumber = trainingSetNumber;
	}

	public Integer getTestSetNumber() {
		return testSetNumber;
	}

	public void setTestSetNumber(Integer testSetNumber) {
		this.testSetNumber = testSetNumber;
	}

	public Integer getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Integer accuracy) {
		this.accuracy = accuracy;
	}

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}
}
