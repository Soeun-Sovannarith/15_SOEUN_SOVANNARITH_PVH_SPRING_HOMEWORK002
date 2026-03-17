package com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories;

import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.StudentRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {


    @Results(id = "studentMap", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id",
                    many = @Many(select = "com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories.CourseRepository.getCoursesByStudentId"))
    })
    @Select("SELECT * FROM students OFFSET #{offset} LIMIT #{size}")
    List<Students> getAllStudent(Integer offset, Integer size);

    @ResultMap("studentMap")
    @Select("SELECT * FROM students WHERE student_id = #{studentId}")
    Students getStudentById(Integer studentId);

    @ResultMap("studentMap")
    @Select("INSERT INTO students (student_name, email, phone_number) VALUES (#{studentName}, #{email}, #{phoneNumber}) RETURNING *")
    Students createStudent(StudentRequest student);

    @ResultMap("studentMap")
    @Select("UPDATE students SET student_name = #{student.studentName}, email = #{student.email}, phone_number = #{student.phoneNumber} WHERE student_id = #{studentId} RETURNING *")
    Students updateStudent(@Param("studentId") Integer studentId, @Param("student") StudentRequest student);

    @Delete("DELETE FROM students WHERE student_id = #{studentId}")
    void deleteStudent(Integer studentId);
}
