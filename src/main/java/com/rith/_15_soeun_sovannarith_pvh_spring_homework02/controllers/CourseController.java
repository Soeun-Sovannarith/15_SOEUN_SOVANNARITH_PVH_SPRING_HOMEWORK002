package com.rith._15_soeun_sovannarith_pvh_spring_homework02.controllers;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.CourseRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiResponse.Response;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Courses;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Get all courses")
    public ResponseEntity<?> getAllCourse(@RequestParam Integer page, @RequestParam Integer size){
        List<Courses> result = courseService.getAllCourse(page,size);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,"Courses fetched successfully"));
    }

    @GetMapping("/{course-id}")
    @Operation(summary = "Get course by ID")
    public ResponseEntity<?> getCourseById(@PathVariable Integer courseId) {
        Courses result = courseService.getCourseById(courseId);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result, "Course retrieved successfully"));
    }

    @PostMapping()
    @Operation(summary = "Create a new course")
    public ResponseEntity<?>addCourse(@RequestBody CourseRequest newCourse){
        Courses result = courseService.addCourse(newCourse, newCourse.getInstructorId());
        return ResponseEntity.ok(Response.ResponseSuccess(result,"Course added successfully"));

    }
    @PutMapping("{course-id}")
    @Operation(summary = "Update course by ID")
    public ResponseEntity<?>updateCourse(@PathVariable ("course-id") Integer courseId,@RequestBody CourseRequest updatedCourse){
        Courses existingcourse = courseService.getCourseById(courseId);
        if(existingcourse == null){
            return ResponseEntity.accepted().body(Response.ResponseFail("No course found with the given ID"));
        }
        Courses bindingResult = courseService.updateCourse(courseId, updatedCourse);
        return ResponseEntity.ok(Response.ResponseSuccess(bindingResult, "Course updated successfully"));
    }

    @DeleteMapping("{course-id}")
    @Operation(summary = "Delete course by ID")
    public ResponseEntity<?>deleteCourse(@PathVariable("course-id") Integer courseId){
        Courses existingcourse = courseService.getCourseById(courseId);
        if(existingcourse == null){
            return ResponseEntity.accepted().body(Response.ResponseFail("No course found with the given ID"));
        }
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok(Response.ResponseSuccess(null,"Course deleted successfully"));

    }

}


