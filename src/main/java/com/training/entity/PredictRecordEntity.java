package com.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "predict_record")
public class PredictRecordEntity extends BaseEntity {

	@Column(name = "content")
	private String content;

	@Column(name = "predict_result")
	private String predictResult;

	@Column(name = "actual_result")
	private String actualResult;

	@Column(name = "is_correct")
	private Boolean isCorrect;

	@Column(name = "model_info")
	private ModelInfoEntity modelInfo;

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPredictResult() {
		return predictResult;
	}

	public void setPredictResult(String predictResult) {
		this.predictResult = predictResult;
	}

	public String getActualResult() {
		return actualResult;
	}

	public void setActualResult(String actualResult) {
		this.actualResult = actualResult;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}
