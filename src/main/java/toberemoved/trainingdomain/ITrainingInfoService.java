package toberemoved.trainingdomain;

import java.util.List;

public interface ITrainingInfoService {
	List<traininginfo> getAllTraininginfo();
	traininginfo getTrainingById(int id);
    boolean addTraininginfo(traininginfo traininginfo);
    void updateTraininginfo(traininginfo traininginfo);
    void deleteTraininginfo(int id);
}
