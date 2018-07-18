package com.volvo.aurora.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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

import com.volvo.aurora.dao.*;
import com.volvo.aurora.entity.*;

@Transactional
@Rollback
@RunWith(JUnitPlatform.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
class ITrainingInfoEntityRepositoryTest {

	@Autowired
	private ITrainingInfoEntityRepository dao;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAll() {
		try {

			List<TrainingInfoEntity> result = dao.findAll();
			assertNotEquals(0, result.size());
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@Test
	void testSave() {
		try {
			java.sql.Date time = new java.sql.Date(System.currentTimeMillis());

			ModelInfoEntity me = new ModelInfoEntity();
			me.setModelName("test3");
			me.setPath("../../test");

			me.setTrainingDate(time);

			TrainingInfoEntity te = new TrainingInfoEntity();
			te.setName("te1");
			te.setAccuracy(8000);
			te.setResultModel(me);
			te.setTotalNumber(19999);
			te.setTestSetNumber(18888);
			te.setTrainingDate(time);

			dao.save(te);
			assertNotNull(te.getId());

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
