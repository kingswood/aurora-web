package com.volvo.aurora.entity;
//import java.io.Serializable;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name="model_info")
public class ModelInfoEntity extends BaseEntity {

//	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="ID")
//	private Integer id;


	@Column(name="training_date")
	private Date trainingDate;

	@Column(name="model_name")
	private String modelName;

	@Column(name="training_method")
	private String trainingMethod;

	@Column(name="path")
	private String path;

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public Date getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(Date trainingDate) {
		this.trainingDate = trainingDate;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getTrainingMethod() {
		return trainingMethod;
	}

	public void setTrainingMethod(String trainingMethod) {
		this.trainingMethod = trainingMethod;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}	
}
