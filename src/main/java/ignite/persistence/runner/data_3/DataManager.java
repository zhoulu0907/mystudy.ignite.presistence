package ignite.persistence.runner.data_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ignite.IgniteCache;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ignite.persistence.bean.TestData;
import ignite.persistence.constant.IgniteConstant;
import ignite.persistence.service.TestDataService;
import ignite.persistence.utils.IgniteUtils;
import lombok.extern.slf4j.Slf4j;

@Component
@Order(3)
@Slf4j
public class DataManager implements CommandLineRunner {

	@Resource
	private IgniteUtils igniteUtils;
	
	@Resource
	private TestDataService testDataService;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		IgniteCache<String, String> cache = igniteUtils.getIgniteInstance().cache(IgniteConstant.PERSIST_CACHE);
		long lastT = System.currentTimeMillis();
		long startT = lastT;
//		List<TestData> batchData = new ArrayList<>();
		Map<String, String> testDataMap = new HashMap<>();
		int batchSize = 100000;
		for (int loop = 1; loop <= 10000000; loop++) {
//			cache.put(""+loop, ""+loop);
//			batchData.add(new TestData("" + loop, ""+loop));
			testDataMap.put(""+loop, ""+loop);
			if (loop % batchSize == 0) {
				long curT = System.currentTimeMillis();
				log.info("Finised: " + (loop / batchSize) + "%, use: " + (curT - lastT) + " ms.");
				lastT = curT;
//				testDataService.insertBatchData(batchData);
//				batchData.clear();
				cache.putAll(testDataMap);
				testDataMap.clear();
			}
//			testDataService.insertTestData(""+loop, ""+loop);
		}
		System.out.println("Total time use: " + (System.currentTimeMillis() - startT));
	}

}
