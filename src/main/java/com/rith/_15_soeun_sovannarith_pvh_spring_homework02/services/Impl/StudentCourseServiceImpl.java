package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.Impl;

import com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories.StudentCourseRepository;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.StudentCourseService;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    private final StudentCourseRepository studentCourseRepository;

    public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public void insertStudentCourse(Integer studentId, Integer courseId) {
        studentCourseRepository.saveStudentCourse(studentId, courseId);
    }

    @Override
    public void deleteStudentCourseByStudentId(Integer studentId) {
        studentCourseRepository.deleteStudentCourseByStudentId(studentId);
    }
}
