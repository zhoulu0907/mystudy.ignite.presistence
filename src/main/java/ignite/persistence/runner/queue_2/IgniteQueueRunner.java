package ignite.persistence.runner.queue_2;

import javax.annotation.Resource;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteQueue;
import org.apache.ignite.configuration.CollectionConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ignite.persistence.utils.IgniteUtils;
import lombok.extern.slf4j.Slf4j;

//@Component
@Order(2)
@Slf4j
public class IgniteQueueRunner implements CommandLineRunner {

	@Resource
	private IgniteUtils igniteUtils;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Ignite ignite = igniteUtils.getIgniteInstance();
		IgniteQueue<Integer> idQueue = ignite.queue("ids", 0, new CollectionConfiguration());
//		log.info("Queue size: " + idQueue.size());
//		for(int loop = 0; loop < 10; loop++) {
//			idQueue.put(loop);
//		}
//		log.info("Queue size: " + idQueue.size());
		idQueue.forEach(n->System.out.println(n));
	}

}
