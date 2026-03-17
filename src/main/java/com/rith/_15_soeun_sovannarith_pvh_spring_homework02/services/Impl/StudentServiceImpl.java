package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.Impl;

import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.StudentRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Students;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories.StudentRepository;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.StudentCourseService;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentCourseService studentCourseService;

    public StudentServiceImpl(StudentRepository studentRepository, StudentCourseService studentCourseService) {
        this.studentRepository = studentRepository;
        this.studentCourseService = studentCourseService;
    }

    @Override
    public List<Students> getAllStudent(Integer page, Integer size) {
        Integer offset = size * (page - 1) ;
        return studentRepository.getAllStudent(offset, size);
    }

    @Override
    public Students getStudentById(Integer studentId) {
        return studentRepository.getStudentById(studentId);
    }

    @Override
    public Students createStudent(StudentRequest student) {
        Students newStudent = studentRepository.createStudent(student);
        if (student.getCourseId() != null) {
            for (Integer courseId : student.getCourseId()) {
                studentCourseService.insertStudentCourse(newStudent.getStudentId(), courseId);
            }
        }
        return getStudentById((newStudent.getStudentId()));
    }

    @Override
    public Students updateStudent(Integer studentId, StudentRequest student) {
        Students existingStudent = getStudentById(studentId);
        if (existingStudent == null) {
            return null;
        }
        studentRepository.updateStudent(studentId, student);
        if (student.getCourseId() != null) {
            studentCourseService.deleteStudentCourseByStudentId(studentId);
            for (Integer courseId : student.getCourseId()) {
                studentCourseService.insertStudentCourse(studentId, courseId);
            }
        }
        return getStudentById(studentId);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentRepository.deleteStudent(studentId);
    }
}
