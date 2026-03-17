package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Courses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Courses> getAllCourse(Integer page, Integer size);

    Courses getCourseById(Integer courseId);
}
