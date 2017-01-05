package com.ndpar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class Cache {

    private static final String PROFILE_MAP = "mapcache";
    private static final String PROFILE_REDIS = "redis";

    private static final Logger log = LoggerFactory.getLogger(Cache.class);

    @Bean
    @Profile(PROFILE_MAP)
    CacheManager concurrentMapCacheManager() {
        log.info("Cache manager is ConcurrentMapCacheManager");
        return new ConcurrentMapCacheManager("keys");
    }

    @Bean
    @Profile(PROFILE_REDIS)
    CacheManager cacheManager() {
        log.info("Cache manager is RedisCacheManager");
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate());
        cacheManager.setDefaultExpiration(60);
        return cacheManager;
    }

    @Bean
    @Profile(PROFILE_REDIS)
    RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }

    @Bean
    @Profile(PROFILE_REDIS)
    RedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("localhost");
        factory.setPort(6379);
        factory.setUsePool(true);
        return factory;
    }
}
