package com.estsoft.controller;

import com.estsoft.repository.StudentJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class HelloController {
    // J2ME => mobile edition => android
    // J2SE => standard
    // J2EE => WEB 기반의 java -> servlet 개념 기본샘플코드.

    @Autowired
    private StudentJdbcRepository studentJdbcRepository;

    @GetMapping("/hello")
    public int hi() {
        return studentJdbcRepository.countOfStudent();
    }

    @GetMapping("/hello/name/list")
    public List<String> getName() {
        return studentJdbcRepository.getStudentNameList();
    }

    @PostMapping("/hello/name/regist")
    public int saveStudent(@RequestParam String name, @RequestParam Integer age) {
        return studentJdbcRepository.insertStudent(name, age);
    }


}