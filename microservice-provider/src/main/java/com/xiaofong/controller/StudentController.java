package com.xiaofong.controller;

import com.xiaofong.entity.Student;
import com.xiaofong.service.StudentService;
import io.prometheus.client.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;


@RestController
@RequestMapping("/provide/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private static Random random = new Random();

    private static final Counter requestTotal = Counter.build()
            .name("my_sample_counter")
            .labelNames("status")
            .help("A simple Counter to illustrate custom Counters in Spring Boot and Prometheus").register();

    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable Integer id) {

        return studentService.fingStudentById(id);

    }

    /**
     * @Author : fengHangWen
     * @CreateDate : 2019/5/27 17:18
     * @Description : prometheus自定义监控
     * @Version : 1.0, 有修改请更新版本号
     */
    @GetMapping("/endpoint")
    public void endpoint() {
        if (random.nextInt(2) > 0) {
            requestTotal.labels("success").inc();
        } else {
            requestTotal.labels("error").inc();
        }
    }

}
