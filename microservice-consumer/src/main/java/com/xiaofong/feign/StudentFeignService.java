package com.xiaofong.feign;

import com.xiaofong.entity.Student;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "${microservice-provider}")
public interface StudentFeignService {

    @GetMapping("/provide/student/getStudentById/{id}")
    Student getStudentById(@PathVariable(value = "id") Integer id);

    @GetMapping("/provide/student/endpoint")
    void endpoint();

}
