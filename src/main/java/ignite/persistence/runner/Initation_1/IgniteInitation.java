package ignite.persistence.runner.Initation_1;

import javax.annotation.Resource;

import org.apache.ignite.Ignite;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import ignite.persistence.cachestore.DataCacheStore;
import ignite.persistence.cachestore.DataCacheStoreFactory;
import ignite.persistence.constant.IgniteConstant;
import ignite.persistence.utils.IgniteUtils;
import ignite.persistence.utils.NodeFilter;

@Component
@Order(1)
public class IgniteInitation implements CommandLineRunner {

	@Resource
	private IgniteUtils igniteUtils;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		initCache();
	}
	private void initCache() {
		// TODO Auto-generated method stub
		
		Ignite ignite = igniteUtils.getIgniteInstance();
		ignite.cluster().active(true);
		
		initPersistCache();
	}
	private void initPersistCache() {
		// TODO Auto-generated method stub
		CacheConfiguration<String, String> cfg = new CacheConfiguration<String, String>();
		cfg.setName(IgniteConstant.PERSIST_CACHE);
		cfg.setIndexedTypes(String.class, Integer.class);
		cfg.setCacheMode(CacheMode.PARTITIONED);
		//db persistence
//		cfg.setWriteThrough(true);
//		cfg.setReadThrough(true);
//		cfg.setWriteBehindEnabled(true);
//		cfg.setWriteBehindFlushSize(100 * 1024 * 1024);
//		cfg.setCacheStoreFactory(new DataCacheStoreFactory());
		igniteUtils.getIgniteInstance().getOrCreateCache(cfg);
	}

}
