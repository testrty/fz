//package com.md.mybatisplus.t.Utils;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import java.io.Serializable;
//
//
///**
// * redis 的相关配置
// * 参考地址：https://zhuanlan.zhihu.com/p/146465201
// *
// * 后续  Jedis的配置弃用，改用lettuce的
// */
//
//@Configuration
//public class RedisConfig {
//
////    @Bean
////    public RedisTemplate<String, Serializable>
////    redisTemplate(LettuceConnectionFactory connectionFactory) {
////        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
////        redisTemplate.setKeySerializer(new StringRedisSerializer());
////        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
////        redisTemplate.setConnectionFactory(connectionFactory);
////        return redisTemplate;
////    }
//    }
