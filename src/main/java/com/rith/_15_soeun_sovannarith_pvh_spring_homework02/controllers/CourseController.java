package com.rith._15_soeun_sovannarith_pvh_spring_homework02.controllers;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiResponse.Response;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Courses;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCourse(@RequestParam Integer page, @RequestParam Integer size){
        List<Courses> result = courseService.getAllCourse(page,size);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,"Courses fetched successfully"));
    }

    @GetMapping("{course-id}")
    public ResponseEntity<?> getCourseById(@RequestParam Integer courseId) {
        Courses result = courseService.getCourseById(courseId);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result, "Course retrieved successfully"));
    }

}


