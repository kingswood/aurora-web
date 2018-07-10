package toberemoved.trainingdomain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.volvo.aurora.entity.ModelInfoEntity;
import com.volvo.aurora.repository.IModelInfoRepository;

@RunWith(JUnitPlatform.class)
@SpringBootTest
@ExtendWith(SpringExtension.class)
class IModelInfoRepositoryTest {

	@Autowired
	IModelInfoRepository repository;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFindAll() {
		
		List<ModelInfoEntity> list = repository.findAll();
		fail("Not yet implemented");
	}

	@Test
	void testFindAllSort() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllByIdIterableOfID() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveAllIterableOfS() {
		fail("Not yet implemented");
	}

	@Test
	void testFlush() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveAndFlush() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteInBatch() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteAllInBatch() {
		fail("Not yet implemented");
	}

	@Test
	void testGetOne() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllExampleOfS() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllExampleOfSSort() {
		fail("Not yet implemented");
	}

}
