package toberemoved;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Date;


@Entity
public class trainingentity {

		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Integer id;

	    private Date traindate;

	    private Long trainingsetnumber;
	    
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

}
