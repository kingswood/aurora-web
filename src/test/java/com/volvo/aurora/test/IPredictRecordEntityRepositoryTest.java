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
public class IPredictRecordEntityRepositoryTest {

	@Autowired
	private IPredictRecordEntityRepository dao;

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
			
		List<PredictRecordEntity> result = dao.findAll();
		assertNotEquals(0, result.size());
		}
		catch (Exception ex) {
			System.out.println(ex);
			}

}}
