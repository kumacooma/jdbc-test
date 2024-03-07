package com.estsoft.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int countOfStudent() {
        return jdbcTemplate.queryForObject("select count(1) from student", Integer.class);
    }

    //모든 학생 이름 조회하기
    public List<String> getStudentNameList() {
        return jdbcTemplate.queryForList("select name from student", String.class);
    }

    //새로운 학생정보 저장하기
    public int insertStudent(String name, int age) {
        return jdbcTemplate.update("insert into student(name, age) values(?, ?)", name, age);
    }

    // TODO
    //   1. ID로 학생정보 조회하기
    //   2. student name or age or desc 컬럼정보 수정하기.


}