package com.rith._15_soeun_sovannarith_pvh_spring_homework02.controllers;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.StudentRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiResponse.Response;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Students;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping()
    public ResponseEntity<?> getAllStudent(@RequestParam Integer page, @RequestParam Integer size){
        List<Students> result = studentService.getAllStudent(page,size);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,"Students retrieved successfully" ));
    }

    @GetMapping("{student-id}")
    public ResponseEntity<?> getStudentById(@RequestParam Integer studentId){
        Students result = studentService.getStudentById(studentId);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,"Student retrieved successfully" ));
    }

    @PostMapping()
    public ResponseEntity<?> createStudent(@RequestBody StudentRequest newStudent){
        StudentRequest result = studentService.createStudent(newStudent);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,"Student created successfully" ));
    }
}
