package com.demo.springboot.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@MapperScan("com.demo.springboot.mapper") //或者直接在Mapper类上面添加注解@Mapper,建议使用前者，不然每个mapper加个注解也挺麻烦的
public class DBConfig {
//	@Autowired
//	ApplicationContext applicationContext;//引入上下文
//	@Autowired
//	DataSourceProperties dataSourceProperties;//引入数据源参数
//	@Value("mybatis.mapper-locations")
//	private String mybatislocation;
//
//	// DataSource配置
//	/**
//	 * "@Bean"注解就不多解释了，就是说把它当成一个Bean类来处理
//	 * "@ConfigurationProperties"注解会默认读取application.proerties文件中的spring.datasource配置，并自动赋值到DataSource中
//	 * @return
//	 */
//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource dataSource() {
//		//		return new org.apache.tomcat.jdbc.pool.DataSource();
//		//case 1 
//		DataSource dataSource = applicationContext.getBean(DataSource.class);
//		return dataSource;
//
//		//		case 2
//		//			DataSource dataSource = new BasicDataSource();
//		//			return dataSource;
//	}
//
//	// 提供SqlSeesion(数据库事务操作相关的配置)
//	@Bean
//	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();//创建SqlSessionFactoryBean类
//		sqlSessionFactoryBean.setDataSource(dataSource());//设置数据库链接
//		//如果你不想写mapper.xml文件来实现功能的话，下面两行可以注释。
//		//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		//		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(getMybatislocation);
//		return sqlSessionFactoryBean.getObject();
//	}
//
//	/**
//	 * @return SqlSession
//	 * @throws Exception
//	 */
//	@Bean
//	public SqlSession sqlSessionBean()throws Exception{
//		SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryBean());
//		return template;
//	}
//	
//	
//	public String getMybatislocation() {
//		return mybatislocation;
//	}
//
//	public void setMybatislocation(String mybatislocation) {
//		this.mybatislocation = mybatislocation;
//	}
}
