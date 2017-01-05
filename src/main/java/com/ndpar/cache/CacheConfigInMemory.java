package com.ndpar.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import static com.ndpar.Profiles.MEMORY;

@Configuration
@Profile(MEMORY)
public class CacheConfigInMemory {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Bean
    public CacheManager cacheManager() {
        log.info("Cache manager is ConcurrentMapCacheManager");
        return new ConcurrentMapCacheManager("keys");
    }
}
