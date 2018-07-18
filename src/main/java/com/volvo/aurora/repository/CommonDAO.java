/*package com.volvo.aurora.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.volvo.aurora.entity.BaseEntity;


@Transactional
@Repository
public class CommonDAO<T extends BaseEntity> implements ICommonDAO<T> {
	
	public Class<T> entityClass;
	
	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@PersistenceContext 
	private EntityManager entityManager;
	
//	@SuppressWarnings("unchecked")
//	public CommonDAO() {
////		this.entityClass = ((Class<T>) ((ParameterizedType) getClass()
////		        .getGenericSuperclass()).getActualTypeArguments()[0]);
////		
//	}
//	
	public CommonDAO(Class<T> tClass) {
		this.entityClass = tClass;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		// TODO Auto-generated method stub
//		String hql = "FROM  as tr1 ORDER BY tr1.id";
		List<T> result = entityManager.createQuery( "from " + entityClass.getName() )
			       .getResultList();
		return result;
	}

	public T getById(int id) {
		System.out.println("id test");
//		Type genType = getClass();//.getGenericSuperclass();  
//        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
//        entityClass = (Class<T>) params[0];  W
		// TODO Auto-generated method stub
		return entityManager.find(entityClass, id);
	       //return entityManager.createQuery(String.format("SELECT e FROM %s e ORDER BY id", entityClass.getSimpleName()), ).getResultList();

	}

	public void add(T entity ) {
		// TODO Auto-generated method stub
		entityManager.persist(entity);
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub
		T entity = getById(id);
		entityManager.remove(entity);
	}
		
	public void update(BaseEntity entity) {
		entityManager.merge(entity);
	}

}

*/