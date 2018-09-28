package ignite.persistence.runner.data_3;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ignite.IgniteCache;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ignite.persistence.constant.IgniteConstant;
import ignite.persistence.utils.IgniteUtils;
import lombok.extern.slf4j.Slf4j;

@Component
@Order(3)
@Slf4j
public class DataManager implements CommandLineRunner {

	@Resource
	private IgniteUtils igniteUtils;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		IgniteCache<String, Integer> cache = igniteUtils.getIgniteInstance().cache(IgniteConstant.PERSIST_CACHE);
		long lastT = System.currentTimeMillis();
		long startT = lastT;
		for (int loop = 1; loop <= 10000000; loop++) {
			if (loop % 100000 == 0) {
				long curT = System.currentTimeMillis();
				log.info("Finised: " + (loop / 100000) + "%, use: " + (curT - lastT) + " ms.");
				lastT = curT;
			}
			cache.put(""+loop, loop);
		}
		System.out.println("Total time use: " + (System.currentTimeMillis() - startT));
	}

}
