package com.xiaofong.service;

import com.xiaofong.dao.StudentDao;
import com.xiaofong.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student fingStudentById(Integer id) {

        return studentDao.findStudentById(id) == null ? new Student() : studentDao.findStudentById(id);

    }

}
