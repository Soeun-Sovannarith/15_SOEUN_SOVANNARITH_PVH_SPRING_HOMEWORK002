package com.rith._15_soeun_sovannarith_pvh_spring_homework02.controllers;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.StudentRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiResponse.Response;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Courses;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Students;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.CourseService;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;


    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }


    @GetMapping()
    @Operation(summary = "Get all students")
    public ResponseEntity<?> getAllStudent(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size){
        List<Students> result = studentService.getAllStudent(page,size);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,200,"Students retrieved successfully" ));
    }

    @GetMapping("/{student-id}")
    @Operation(summary = "Get student by ID")
    public ResponseEntity<?> getStudentById(@PathVariable("student-id") Integer studentId){
        Students result = studentService.getStudentById(studentId);
        if(result == null){
            return ResponseEntity.accepted().body(Response.ResponseFail("No student found with the given ID"));
        }
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,200,"Student retrieved successfully" ));
    }

    @PostMapping()
    @Operation(summary = "Create a new student")
    public ResponseEntity<?> createStudent(@RequestBody StudentRequest newStudent){
        for(Integer courseId : newStudent.getCourseId()){
            Courses courses = courseService.getCourseById(courseId);
            if(courses==null){
                return ResponseEntity.accepted().body(Response.ResponseFail("No courses found with the given ID"));
            }
        }
        Students result = studentService.createStudent(newStudent);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,201,"Student created successfully" ));
    }

    @PutMapping("/{student-id}")
    @Operation(summary = "Update student by ID")
    public ResponseEntity<?> updateStudent(@PathVariable("student-id") Integer studentId, @RequestBody StudentRequest student) {
        Students existingstudents = studentService.getStudentById(studentId);
        if(existingstudents == null){
            return ResponseEntity.accepted().body(Response.ResponseFail("No students found with the given ID"));
        }
        for(Integer courseId : student.getCourseId()){
            Courses course = courseService.getCourseById(courseId);
            if(course == null){
                return ResponseEntity.accepted().body(Response.ResponseFail("No courses found with the given ID"));
            }
        }
        Students result = studentService.updateStudent(studentId, student);
        return ResponseEntity.ok().body(Response.ResponseSuccess(result,200, "Student updated successfully"));
    }

    @DeleteMapping("/{student-id}")
    @Operation(summary = "Delete student by ID")
    public ResponseEntity<?> deleteStudent(@PathVariable("student-id") Integer studentId) {
        Students existingstudents = studentService.getStudentById(studentId);
        if(existingstudents == null){
            return ResponseEntity.accepted().body(Response.ResponseFail("No students found with the given ID"));
        }
        return ResponseEntity.ok().body(Response.ResponseSuccess(null, 200, "Student deleted successfully"));
    }
}
