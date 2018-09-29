package ignite.persistence.mapper;

import java.util.List;

import ignite.persistence.bean.TestData;

public interface TestDataMapper {
	public void insertTestData(String name, String value);

	public void insertBatchData(List<TestData> batchData);
}
