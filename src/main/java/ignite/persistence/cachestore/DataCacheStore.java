package ignite.persistence.cachestore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.cache.Cache;
import javax.cache.Cache.Entry;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.resources.SpringResource;

import ignite.persistence.bean.TestData;
import ignite.persistence.service.TestDataService;

public class DataCacheStore extends MyCacheStoreAdapter<String, String> {

	@SpringResource(resourceName="TestDataService")
	private transient TestDataService testDataService;

	@Override
	public String load(String arg0) throws CacheLoaderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object arg0) throws CacheWriterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(Entry<? extends String, ? extends String> e) throws CacheWriterException {
		// TODO Auto-generated method stub
//		testDataService.insertTestData(e.getKey(), ""+e.getValue());
	}

	@Override
	public void writeAll(Collection<Entry<? extends String, ? extends String>> entries) throws CacheWriterException {
		// TODO Auto-generated method stub
		List<TestData> batchData = new ArrayList<>();
		entries.forEach(n->batchData.add(new TestData(n.getKey(), n.getValue())));
		testDataService.insertBatchData(batchData);
	}

}
