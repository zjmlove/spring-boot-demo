package com.demo.springboot.service;

import com.demo.springboot.domain.Demo;

public interface DemoService {
	/**
	 * 接口定义 
	 * @param id
	 * @return
	 */
	Demo getDemoById(Long id);

	void updateDemo(Demo demo);

	void removeDemo(Demo demo);
}
