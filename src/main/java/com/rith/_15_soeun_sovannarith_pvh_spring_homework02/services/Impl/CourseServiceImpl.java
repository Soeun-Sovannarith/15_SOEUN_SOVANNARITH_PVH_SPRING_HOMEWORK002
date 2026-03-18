package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.Impl;

import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.CourseRequest;
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

    @Override
    public Courses addCourse( CourseRequest newCourse, Integer instructorId) {
        return courseRepository.addCourse( newCourse, instructorId);
    }

    @Override
    public Courses updateCourse(Integer courseId, CourseRequest updatedCourse) {
        return courseRepository.updateCourse(courseId, updatedCourse);
    }

    @Override
    public void deleteCourse(Integer courseId) {
        courseRepository.deleteCourse(courseId);
    }
}
