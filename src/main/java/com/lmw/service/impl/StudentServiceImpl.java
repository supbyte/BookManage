package com.lmw.service.impl;

import com.lmw.entity.Student;
import com.lmw.mapper.StudentMapper;
import com.lmw.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }
}
