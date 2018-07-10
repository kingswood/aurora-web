package demo.trainingdomain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name="train_info")
public class traininginfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
    private Integer id;

	@Column(name="TRAIN_DATE")
    private Date traindate;

	@Column(name="TRAIN_DATA_NUM")
    private Long trainingsetnumber;
    
	@Column(name="ACCURACY")
	private Integer accuracy;
	
    public Integer getId() {
    	return id;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
    public Date getTraindate() {
    	return traindate;
    }
    
    public void setTraindate(Date date) {
    	this.traindate = date;
    }
    
    public Long getTrainingSetNumber() {
    	return trainingsetnumber;
    }
    
    public void setTrainingSetNumber(Long number) {
    	this.trainingsetnumber = number;
    }
    
    public Integer getAccuracy() {
    	return accuracy;
    }
    
    public void setAccuracy(Integer accuracy) {
    	this.accuracy = accuracy;
    }
}
