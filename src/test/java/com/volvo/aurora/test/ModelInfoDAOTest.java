package com.volvo.aurora.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.volvo.aurora.dao.IModelInfoRepository;
import com.volvo.aurora.entity.ModelInfoEntity;


@Transactional
@Rollback
@RunWith(JUnitPlatform.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ModelInfoDAOTest {

	@Autowired
	private IModelInfoRepository dao;

	
	@BeforeEach
	void setUp() throws Exception {
//		ModelInfoEntity mEntity = new ModelInfoEntity();
//		Class c = mEntity.getClass();
//		dao = new ModelInfoDAO(c);
//		
		System.out.println("test start");
	}

	@Test
	void testGetAll() {
		try {
			
			List<ModelInfoEntity> result = dao.findAll();
		assertNotEquals(0, result.size());
		}
		//fail("Not yet implemented");
		catch (Exception ex) {
		System.out.println(ex);
		}
	}

	@Test
	void testGetById() {
		try {
		System.out.println("test get by id");
		Optional<ModelInfoEntity> entity = dao.findById(1);
		//System.out.println(entity.getId());
		assertNotEquals(null,entity);
		//fail("Not yet implemented");
		}
		catch(Exception ex) {
			System.out.println(ex);
		}
	}

	@Test
	void createModel() {
		try {
			ModelInfoEntity entity = new ModelInfoEntity();
			entity.setModelName("test2");
			dao.save(entity);
			assertNotNull(entity.getId());
		}
		catch(Exception ex) {
			
		}
	}

}
