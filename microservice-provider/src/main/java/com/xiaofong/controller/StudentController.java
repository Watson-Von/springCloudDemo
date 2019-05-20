package com.xiaofong.controller;

import com.xiaofong.entity.Student;
import com.xiaofong.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/provide/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable Integer id) {

        return studentService.fingStudentById(id);

    }

}
