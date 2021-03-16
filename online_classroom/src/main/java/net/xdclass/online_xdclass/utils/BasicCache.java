package net.xdclass.online_xdclass.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class BasicCache {

    // https://github.com/google/guava/wiki/CachesExplained
    private Cache<String, Object> tenMinCache = CacheBuilder.newBuilder()
                                                            .initialCapacity(10)
                                                            .maximumSize(100)
                                                            .concurrencyLevel(5)
                                                            .expireAfterWrite(600, TimeUnit.SECONDS)
                                                            .recordStats()
                                                            .build();

    private Cache<String, Object> oneHourCache = CacheBuilder.newBuilder()
                                                .initialCapacity(10)
                                                .maximumSize(100)
                                                .concurrencyLevel(5)
                                                .expireAfterWrite(3600, TimeUnit.SECONDS)
                                                .recordStats()
                                                .build();

    public Cache<String, Object> getTenMinCache() {
        return tenMinCache;
    }

    public void setTenMinCache(Cache<String, Object> tenMinCache) {
        this.tenMinCache = tenMinCache;
    }

    public Cache<String, Object> getOneHourCache() {
        return oneHourCache;
    }

    public void setOneHourCache(Cache<String, Object> oneHourCache) {
        this.oneHourCache = oneHourCache;
    }
}
