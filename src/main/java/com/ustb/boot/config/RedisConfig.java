package com.ustb.boot.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * packageName com.lxk.boot.config
 *
 * @author 柳新宽
 * @version 1.0
 * @className RedisConfig
 * @date 2024/7/15
 * @description TODO
 */
@Configuration
@EnableCaching //使用redis作为缓存技术
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        //1.创建一个默认的RedisTemplate对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //2.创建用于redisTemplate的序列化对象(String)
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer(StandardCharsets.UTF_8);
        //3.创建用于redisTemplate的序列化对象(Json)
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //4.设置jackson序列化扫描规则
        ObjectMapper om = new ObjectMapper();
        //两个参数。第一个参数负责哪些对象元素参与序列化。第二个参数表示什么修饰符的元素参与序列化
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //5.把对象的类型信息也参与到序列化中，用于反序列化的时候进行类型转换
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        //6.把设置成效
        jackson2JsonRedisSerializer.setObjectMapper(om);
        //7.配置redisTemplate
        //7.1 设置连接工厂
        template.setConnectionFactory(redisConnectionFactory);
        //7.2 设置key的序列化方案
        template.setKeySerializer(stringRedisSerializer);
        //7.3 设置value的序列化方案
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //7.4 设置hashValue的序列化方案
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        //8.设置是否开启全局事务 一般不开启
        //template.setEnableTransactionSupport(true);
        return template;
    }
    //设置缓存管理器
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer(StandardCharsets.UTF_8);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(600))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringRedisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .disableCachingNullValues();//禁止缓存空值  根据业务场景
        RedisCacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(configuration)
                .build();
        return cacheManager;
    }
}