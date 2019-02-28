package com.demo.springboot.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching //启用缓存机制
//@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {
	 /**
     * 缓存管理器
     * 目的： 拯救性能 https://www.jianshu.com/p/fc076b6c2a13
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
    	 RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                 .entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
         return RedisCacheManager
                 .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                 .cacheDefaults(redisCacheConfiguration).build();
    }
    /**
     * CacheManager 用法示例 ：
     */
//    @RequestMapping("/getUser")
//    @Cacheable(value="user-key")
//    public User getUser() {
//        User user=userRepository.findByUserName("aa");
//        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
//        return user;
//    }
//    其中value的值就是缓存到redis中的key
	
	/**
	 * redis模板操作类,类似于jdbcTemplate的一个类;
	 * 虽然CacheManager也能获取到Cache对象，但是操作起来没有那么灵活；
	 * 这里在扩展下：RedisTemplate这个类不见得很好操作，我们可以在进行扩展一个我们
	 * 自己的缓存类，比如：RedisStorage类;
	 * @param factory : 通过Spring进行注入，参数在application.properties进行配置；
	 * @return
	 */
	@Bean(name="redisTemplate")
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
		// case 0
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(factory);

		//key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
		//所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现ObjectRedisSerializer
		//或者JdkSerializationRedisSerializer序列化方式;
		//     RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
		//     redisTemplate.setKeySerializer(redisSerializer);
		//     redisTemplate.setHashKeySerializer(redisSerializer);
		
		//		设置 key 和 value 的序列化方式
		//		redisTemplate.setKeySerializer(keySerializer());
		//		redisTemplate.setHashKeySerializer(keySerializer());
		//		redisTemplate.setValueSerializer(valueSerializer());
		//		redisTemplate.setHashValueSerializer(valueSerializer());

		return redisTemplate;
	}

	@SuppressWarnings("unused")
	private RedisSerializer<String> keySerializer() {
		return new StringRedisSerializer();
	}
	
	//使用Jackson序列化器
	@SuppressWarnings("unused")
	private RedisSerializer<Object> valueSerializer() {
		return new GenericJackson2JsonRedisSerializer();
	}
}
