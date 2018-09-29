package ignite.persistence.cachestore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.cache.Cache;

import org.apache.ignite.cache.store.CacheStore;
import org.apache.ignite.internal.util.typedef.internal.S;
import org.apache.ignite.lang.IgniteBiInClosure;
import org.apache.ignite.lang.IgniteBiPredicate;

public abstract class MyCacheStoreAdapter<K, V> implements CacheStore<K, V> {
    /**
     * Default empty implementation. This method needs to be overridden only if
     * {@link org.apache.ignite.IgniteCache#loadCache(IgniteBiPredicate, Object...)} method
     * is explicitly called.
     *
     * @param clo {@inheritDoc}
     * @param args {@inheritDoc}
     */
    @Override public void loadCache(IgniteBiInClosure<K, V> clo, Object... args) {
        /* No-op. */
    }

    /** {@inheritDoc} */
    @Override public Map<K, V> loadAll(Iterable<? extends K> keys) {
        assert keys != null;

        Map<K, V> loaded = new HashMap<>();

        for (K key : keys) {
            V v = load(key);

            if (v != null)
                loaded.put(key, v);
        }

        return loaded;
    }

    /** {@inheritDoc} */
    @Override public void deleteAll(Collection<?> keys) {
        assert keys != null;

        for (Object key : keys)
            delete(key);
    }

    /**
     * Default empty implementation for ending transactions. Note that if explicit cache
     * transactions are not used, then transactions do not have to be explicitly ended -
     * for all other cases this method should be overridden with custom commit/rollback logic.
     *
     * @param commit {@inheritDoc}
     */
    @Override public void sessionEnd(boolean commit) {
        // No-op.
    }

    /** {@inheritDoc} */
    @Override public String toString() {
        return S.toString(MyCacheStoreAdapter.class, this);
    }
}
