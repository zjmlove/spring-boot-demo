package com.demo.springboot.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.springboot.config.SystemParams;
import com.demo.springboot.domain.Demo;
import com.demo.springboot.domain.repository.DemoRepository;
import com.demo.springboot.service.DemoService;
import com.demo.springboot.service.impl.DemoServiceImpl;
import com.demo.springboot.util.ConstantsUtil;

/**
 * @RestController 注解优点：  
 * 	1.默认类中的方法都会以json的格式返回
 * 	2.不需要增加pom对jackson等包的依赖
 * 	3.无需扫描包
 * 	4.对接方法无需使用@responsebody
 *
 * @author zhangjiamei
 *
 */
@RestController
public class DemoController {
	@Autowired
	private SystemParams systemParams;

	@Autowired
	private RedisTemplate redisTemplate;
	private StringRedisSerializer stringSerializer = new StringRedisSerializer();
	@SuppressWarnings("unused")
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	@Resource(name=DemoServiceImpl.SERVICE_NAME)
	private DemoService demoService;

	/**
	 * 接口访问测试。
	 * @return
	 */
	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}
	/**
	 * 自定义参数测试，返回json格式。
	 * @return
	 */
	@RequestMapping("/params")
	public SystemParams params() {
		return systemParams;
	}
	/**
	 * redis set 测试
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/redisSet")
	public String redisset(String param) {
		final byte[] key = stringSerializer.serialize(ConstantsUtil.normal_key_pre + param);
		final byte[] field = stringSerializer.serialize(ConstantsUtil.normal_field_pre + param);
		final byte[] v = com.demo.springboot.util.SerializeUtil.serialize(ConstantsUtil.normal_value_pre + param);
		Object flagBol = redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				Boolean flag = false;
				if(v!=null){
					flag = connection.hSet(key, field, v);
				}
				connection.expire(key, ConstantsUtil.redis_time_out);
				System.out.println("hset redis result："+flag);
				return flag;
			}
		});
		System.out.println("confirm hset redis result："+String.valueOf(flagBol));
		return "over";
	}
	/**
	 * redis get 测试
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/redisGet")
	public String redisget(String param) {
		final byte[] key = stringSerializer.serialize(ConstantsUtil.normal_key_pre + param);
		final byte[] field = stringSerializer.serialize(ConstantsUtil.normal_field_pre + param);
		Object obj = redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				return com.demo.springboot.util.SerializeUtil.unserialize(connection.hGet(key, field));
			}
		});
		return String.valueOf(obj);
	}
	/**
	 * redis delete 测试
	 * @param param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/redisDel")
	public String redisDel(String param) {
		final byte[] key = stringSerializer.serialize(ConstantsUtil.normal_key_pre + param);
		final byte[] field = stringSerializer.serialize(ConstantsUtil.normal_field_pre + param);
		Object number = redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				long i = connection.hDel(key, field);
				return i;
			}
		});
		return String.valueOf(number);
	}

	@RequestMapping("/getDemoRe")
	public DemoRepository getDemoRe(Long id) {
		return demoService.selectDemoRepositoryByPrimaryKey(id);
	}
	
	@RequestMapping("/getDemo")
	public Demo getDemo(Long id) {
		return demoService.getDemoById(id);
	}
	
	@RequestMapping("/updateDemo")
	public void update(String info) {
		Demo demo = demoService.getDemoById(1L);
		demo.setInfo(info);
		demoService.updateDemo(demo);
	}

	@RequestMapping("/insertDemo")
	public void insertDemo(String name, String info) {
		demoService.insertDemo(new Demo(null, name, info));
	}

	@RequestMapping("/deleteDemo")
	public void deleteDemo(Long id) {
		Demo demo = new Demo(id);
		demoService.removeDemo(demo);
	}
}