package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.Impl;

import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.StudentRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Students;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories.StudentRepository;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Students> getAllStudent(Integer page, Integer size) {
        Integer offset = size * (page - 1) ;
        return studentRepository.getAllStudent(offset, size);
    }

    @Override
    public Students getStudentById(Integer studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public StudentRequest createStudent(StudentRequest student) {
//        return studentRepository.createStudent(student);
        return null;
    }
}
