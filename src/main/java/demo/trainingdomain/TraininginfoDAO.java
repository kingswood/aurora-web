package demo.trainingdomain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TraininginfoDAO implements ITraininginfoDAO {

	@PersistenceContext
	private EntityManager entityManager;
//	
//	public void forTest() {
//		if (entityManager == null) {
//			entityManager = new EntityManager();
//		}
//	}
//	
	public TraininginfoDAO() {
		System.out.println("Constructing trainingInfoDao");
	}
	
	@SuppressWarnings("unchecked")
	public List<traininginfo> getAlltraininginfo() {
		// TODO Auto-generated method stub
		String hql = "FROM traininginfo as tr1 ORDER BY tr1.id";
		List<traininginfo> result = entityManager.createQuery(hql).getResultList();
		return result;
	}

	public traininginfo gettraininginfoById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(traininginfo.class, id);
	}

	public void addTraininginfo(traininginfo traininginfo) {
		// TODO Auto-generated method stub
		entityManager.persist(traininginfo);
	}

	public void updateTraininginfo(traininginfo traininginfo) {
		// TODO Auto-generated method stub
		traininginfo info = gettraininginfoById(traininginfo.getId());
		info.setTraindate(traininginfo.getTraindate());
		info.setAccuracy(traininginfo.getAccuracy());
		info.setTrainingSetNumber(traininginfo.getTrainingSetNumber());
		entityManager.flush();

	}

	public void deleteTraininginfo(int id) {
		// TODO Auto-generated method stub
		entityManager.remove(id);

	}

}
