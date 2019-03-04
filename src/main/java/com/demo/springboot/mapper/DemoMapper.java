package com.demo.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.demo.springboot.domain.Demo;
import com.demo.springboot.domain.repository.DemoRepository;

public interface DemoMapper {
	
	@Select("SELECT demo.id,demo.name,demo.info,user.email,user.username FROM test.test_demo demo, master_data.md_user user "
			+ "where user.id = demo.id and demo.id = #{id}")
    @Results({
        @Result(property = "id",  column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "info", column = "info"),
        @Result(property = "email", column = "email"),
        @Result(property = "username", column = "username")
    })
    DemoRepository selectDemoRepositoryByPrimaryKey(@Param("id") Long id);
	
    @Select("SELECT * FROM test.test_demo where id = #{id}")
    @Results({
        @Result(property = "id",  column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "info", column = "info")
    })
    Demo getOne(@Param("id") Long id);
    
    
    @Select("SELECT * FROM test.test_demo")
    @Results({
        @Result(property = "id",  column = "id"),
        @Result(property = "name", column = "name")
    })
    List<Demo> getAll();
    
    @Delete("delete from test.demo where id = #{id}")
    int delete(@Param("id") Long id);
    
    @Insert("insert test.demo(name,info) value(#{name},#{info})")
    int insert(Demo record);
    
    @Update("update test.demo set name=#{name},info=#{info} where id = #{id}")
    int update(@Param("id") Demo record);

}