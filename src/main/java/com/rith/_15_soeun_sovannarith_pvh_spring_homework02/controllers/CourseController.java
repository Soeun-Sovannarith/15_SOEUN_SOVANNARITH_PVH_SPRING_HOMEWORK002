package com.rith._15_soeun_sovannarith_pvh_spring_homework02.controllers;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.CourseRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiResponse.Response;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Courses;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{course-id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer courseId) {
        Courses result = courseService.getCourseById(courseId);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result, "Course retrieved successfully"));
    }

    @PostMapping()
    public ResponseEntity<?>addCourse(@RequestBody CourseRequest newCourse){
        Courses result = courseService.addCourse(newCourse, newCourse.getInstructorId());
        return ResponseEntity.ok(Response.ResponseSuccess(result,"Course added successfully"));

    }
    @PutMapping("{course-id}")
    public ResponseEntity<?>updateCourse(@PathVariable ("course-id") Integer courseId,@RequestBody CourseRequest updatedCourse){
        Courses bindingResult = courseService.updateCourse(courseId, updatedCourse);
        return ResponseEntity.ok(Response.ResponseSuccess(bindingResult, "Course updated successfully"));
    }

    @DeleteMapping("{course-id}")
    public ResponseEntity<?>deleteCourse(@PathVariable("course-id") Integer courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok(Response.ResponseSuccess(null,"Course deleted successfully"));

    }

}


