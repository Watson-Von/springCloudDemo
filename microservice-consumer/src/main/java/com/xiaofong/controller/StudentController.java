package com.xiaofong.controller;

import com.xiaofong.entity.Student;
import com.xiaofong.feign.StudentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/student")
public class StudentController {

    // 订单服务提供者模块的 url 前缀
    //private static final String PROVIDER_URL_PREFIX = "http://localhost:8001";
    private static final String PROVIDER_URL_PREFIX = "http://MICROSERVICE-PROVIDER";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StudentFeignService studentFeignService;

    /**
     * ribbon负载均衡方式调用
     *
     * @param id
     * @return
     */
    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) {

        ResponseEntity<Student> student = restTemplate.getForEntity(PROVIDER_URL_PREFIX +
                "/provide/student/getStudentById/" + id, Student.class);

        if (student == null) {
            return new Student();
        }

        return student.getBody();

    }

    /**
     * feign方式调用
     *
     * @param id
     * @return
     */
    @GetMapping("feign/getStudentById/{id}")
    public Student getStudenByIdWithFeign(@PathVariable("id") Integer id) {

        Student student = studentFeignService.getStudentById(id);

        if (student == null) {
            return new Student();
        }

        return student;
    }


    @GetMapping("/prometheus")
    public void endpoint() {
        studentFeignService.endpoint();
    }

}
