package com.rith._15_soeun_sovannarith_pvh_spring_homework02.controllers;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.InstructorRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiResponse.Response;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Instructor;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Get all instructors")
    public ResponseEntity<?>getAllInstructor(@RequestParam Integer page, @RequestParam Integer size){
        List<Instructor> result = instructorService.getAllInstructor(page,size);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,200,"Instructor fetched successfully"));
    }

    @GetMapping("/{instructor-id}")
    @Operation(summary = "Get instructor by ID")
    public ResponseEntity<?> getInstructorById(@PathVariable("instructor-id") Integer instructorId) {
        Instructor result = instructorService.getInstructorById(instructorId);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result, 200,"Instructor retrieved successfully"));
    }

    @PostMapping()
    @Operation(summary = "Create a new instructor")
    public ResponseEntity<?> createInstructor(@RequestBody InstructorRequest newInstructor){
        Instructor result = instructorService.createInstructor(newInstructor);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,201,"Instructor created successfully" ));
    }

    @PutMapping("{instructor-id}")
    @Operation(summary = "Update instructor by ID")
    public ResponseEntity<?> updateInstructor(@PathVariable("instructor-id") Integer instructorId, InstructorRequest updatedInstructor) {
        Instructor existingInstructor = instructorService.getInstructorById(instructorId);
        if(existingInstructor == null ){
            return ResponseEntity.accepted().body(Response.ResponseFail("No instructors found with the given ID"));
        }
        Instructor result = instructorService.updateInstructor(instructorId,updatedInstructor);
        return ResponseEntity.ok(Response.ResponseSuccess(result,200,"Instructor updated successfully"));

    }

    @DeleteMapping("{instructor-id}")
    @Operation(summary = "Delete instructor by ID")
    public ResponseEntity<?> deleteInstructor(@PathVariable("instructor-id") Integer instructorId){
        Instructor existingInstructor = instructorService.getInstructorById(instructorId);
        if(existingInstructor == null ){
            return ResponseEntity.accepted().body(Response.ResponseFail("No instructors found with the given ID"));
        }
        Instructor result = instructorService.deleteInstructor(instructorId);

        return ResponseEntity.ok(Response.ResponseSuccess(result,200,"Instructor deleted successfully"));
    }



}
