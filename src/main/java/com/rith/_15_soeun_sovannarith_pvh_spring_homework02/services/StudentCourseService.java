package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services;

import org.springframework.stereotype.Service;

@Service
public interface StudentCourseService {
    void insertStudentCourse(Integer studentId, Integer courseId);

    void deleteStudentCourseByStudentId(Integer studentId);
}
