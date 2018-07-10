package demo.trainingdomain;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TraininginfoService implements ITrainingInfoService {

	@Autowired
	private ITraininginfoDAO traininginfoDAO;
	
	public List<traininginfo> getAllTraininginfo() {
		// TODO Auto-generated method stub
		return traininginfoDAO.getAlltraininginfo();
	}

	public traininginfo getTrainingById(int id) {
		// TODO Auto-generated method stub
		return traininginfoDAO.gettraininginfoById(id);
	}

	public synchronized boolean addTraininginfo(traininginfo traininginfo) {
		// TODO Auto-generated method stub
		traininginfoDAO.addTraininginfo(traininginfo);
		return true;
		
    }

	public void updateTraininginfo(traininginfo traininginfo) {
		// TODO Auto-generated method stub
		traininginfoDAO.updateTraininginfo(traininginfo);
	}

	public void deleteTraininginfo(int id) {
		// TODO Auto-generated method stub

	}

}
