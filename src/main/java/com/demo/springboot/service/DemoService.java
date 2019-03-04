package com.demo.springboot.service;

import java.util.List;
import com.demo.springboot.domain.Demo;
import com.demo.springboot.domain.repository.DemoRepository;

public interface DemoService {
	
	Demo getDemoById(Long id);

	void updateDemo(Demo demo);

	void removeDemo(Demo demo);
	
	void insertDemo(Demo demo);
	
	DemoRepository selectDemoRepositoryByPrimaryKey(Long id);
}
