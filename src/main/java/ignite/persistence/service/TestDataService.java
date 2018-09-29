package ignite.persistence.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ignite.persistence.bean.TestData;
import ignite.persistence.mapper.TestDataMapper;

@Service(value="TestDataService")
public class TestDataService {
	
	@Resource
	private TestDataMapper testDataMapper;
	
	public void insertTestData(String name, String value) {
		testDataMapper.insertTestData(name, value);
	}

	public void insertBatchData(List<TestData> batchData) {
		// TODO Auto-generated method stub
		testDataMapper.insertBatchData(batchData);
	}

}
