package ignite.persistence.cachestore;

import javax.cache.configuration.Factory;

import org.apache.ignite.cache.store.CacheStore;

public class DataCacheStoreFactory implements Factory<CacheStore<String, String>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public CacheStore<String, String> create() {
		// TODO Auto-generated method stub
		return new DataCacheStore();
	}

}
