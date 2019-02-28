package com.demo.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.demo.springboot.domain.Demo;
import com.demo.springboot.domain.repository.DemoRepository;

public interface DemoMapper {
	
	@Select("SELECT demo.id,demo.name,demo.info,user.email FROM test.test_demo demo, master_data.md_user user "
			+ "where user.id = demo.id and demo.id = #{id}")
    @Results({
        @Result(property = "id",  column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "info", column = "info"),
        @Result(property = "email", column = "email")
    })
    DemoRepository selectDemoRepositoryByPrimaryKey(Long id);
	
//    int deleteByPrimaryKey(Long id);
//
//    int insert(Demo record);
//    
//    int insertSelective(Demo record);
//    
////    @Select("SELECT * FROM test.test_demo where id = #{id}")
////    @Results({
////        @Result(property = "id",  column = "id"),
////        @Result(property = "name", column = "name"),
////        @Result(property = "info", column = "info")
////    })
//    Demo selectByPrimaryKey(Long id);
//    
//    
//    
//    int updateByPrimaryKeySelective(Demo record);
//
//    int updateByPrimaryKey(Demo record);
//    
////    @Select("SELECT * FROM test.test_demo")
////    @Results({
////        @Result(property = "id",  column = "id"),
////        @Result(property = "name", column = "name")
////    })
//    List<Demo> getAll();
}