package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.Impl;

import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Courses;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories.CourseRepository;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Courses> getAllCourse(Integer page, Integer size) {
        Integer offset = size * (page - 1) ;
        return courseRepository.getAllCourse(offset, size);
    }

    @Override
    public Courses getCourseById(Integer courseId) {

        return courseRepository.getCourseById(courseId);
    }
}
