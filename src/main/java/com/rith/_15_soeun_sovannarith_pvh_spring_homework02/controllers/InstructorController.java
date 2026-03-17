package com.rith._15_soeun_sovannarith_pvh_spring_homework02.controllers;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiResponse.Response;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Courses;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Instructor;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.CourseService;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @GetMapping()
    public ResponseEntity<?>getAllInstructor(@RequestParam Integer page, @RequestParam Integer size){
        List<Instructor> result = instructorService.getAllInstructor(page,size);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,"Instructor fetched successfully"));
    }

    @GetMapping("{instructor-id}")
    public ResponseEntity<?> getInstructorById(@RequestParam Integer instructorId) {
        Instructor result = instructorService.getInstructorById(instructorId);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result, "Instructor retrieved successfully"));
    }
}
