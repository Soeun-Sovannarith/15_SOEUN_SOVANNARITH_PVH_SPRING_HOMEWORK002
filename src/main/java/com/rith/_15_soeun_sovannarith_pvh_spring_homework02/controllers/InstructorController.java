package com.rith._15_soeun_sovannarith_pvh_spring_homework02.controllers;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.InstructorRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiResponse.Response;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Instructor;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{instructorId}")
    public ResponseEntity<?> getInstructorById(@PathVariable Integer instructorId) {
        Instructor result = instructorService.getInstructorById(instructorId);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result, "Instructor retrieved successfully"));
    }

    @PostMapping()
    public ResponseEntity<?> createInstructor(@RequestBody InstructorRequest newInstructor){
        Instructor result = instructorService.createInstructor(newInstructor);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,"Instructor created successfully" ));
    }

    @PutMapping("{instructor-id}")
    public ResponseEntity<?> updateInstructor(@PathVariable("instructor-id") Integer instructorId, InstructorRequest updatedInstructor) {
        Instructor result = instructorService.updateInstructor(instructorId,updatedInstructor);
        return ResponseEntity.ok(Response.ResponseSuccess(result,"Instructor updated successfully"));

    }

    @DeleteMapping("{instructor-id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable("instructor-id") Integer instructorId){


        Instructor result = instructorService.deleteInstructor(instructorId);

        return ResponseEntity.ok(Response.ResponseSuccess(result,"Instructor deleted successfully"));
    }


}
