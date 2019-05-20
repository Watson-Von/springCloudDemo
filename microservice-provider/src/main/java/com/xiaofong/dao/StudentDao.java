package com.xiaofong.dao;

import com.xiaofong.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentDao {

    Student findStudentById(@Param("id") Integer id);

}
