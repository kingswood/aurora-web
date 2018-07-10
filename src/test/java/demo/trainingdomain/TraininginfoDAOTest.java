package demo.trainingdomain;

import static org.junit.jupiter.api.Assertions.*;

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
import demo.trainingdomain.TraininginfoDAO;

//@ContextConfiguration(classes={Config.class, TestConfig.class})
@Transactional
@Rollback
//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(JUnitPlatform.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
class TraininginfoDAOTest  {
	
	@Autowired
	ITraininginfoDAO dao;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testGetId() {
		try {
			
			//ITraininginfoDAO dao = new TraininginfoDAO();
			
			traininginfo info =	dao.gettraininginfoById(1);
			System.out.println(info.getId());
			//assert.notNullValue(info);
			fail("Not yet implemented");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
