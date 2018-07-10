package demo.trainingdomain;
import java.util.List;

public interface ITraininginfoDAO {
	
	List<traininginfo> getAlltraininginfo();
	traininginfo gettraininginfoById(int id);
	void addTraininginfo(traininginfo traininginfo);
    void updateTraininginfo(traininginfo traininginfo);
    void deleteTraininginfo(int id);
   // boolean traininginfoExists(String title, String category);
}
