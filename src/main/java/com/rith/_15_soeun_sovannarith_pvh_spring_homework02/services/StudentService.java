package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.StudentRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Students;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Students> getAllStudent(Integer page, Integer size);

    Students getStudentById(Integer studentId);

    Students createStudent(StudentRequest student);

    Students updateStudent(Integer studentId, StudentRequest student);

    void deleteStudent(Integer studentId);
}
