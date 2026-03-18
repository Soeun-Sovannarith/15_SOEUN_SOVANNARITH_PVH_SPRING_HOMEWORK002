package com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.CourseRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Courses;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName",column = "course_name"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories.InstructorRepository.getInstructorById"))

    })
    @Select("Select * from courses OFFSET #{offset} LIMIT #{size}")
    List<Courses> getAllCourse(@Param("offset") Integer offset, @Param("size") Integer size);

    @ResultMap("courseMapper")
    @Select("Select * from courses where course_id = #{courseId}")
    Courses getCourseById(Integer courseId);

    @ResultMap("courseMapper")
    @Select("SELECT c.* FROM courses c JOIN student_course sc ON c.course_id = sc.course_id WHERE sc.student_id = #{studentId}")
    List<Courses> getCoursesByStudentId(Integer studentId);

    @ResultMap("courseMapper")
    @Select("INSERT INTO courses (course_name, description,instructor_id) VALUES (#{req.courseName}, #{req.description}, #{instructorId})")
    Courses addCourse( @Param("req") CourseRequest newCourse, @Param("instructorId")Integer instructorId);

    @ResultMap("courseMapper")
    @Select("UPDATE courses SET course_name = #{req.courseName}, description = #{req.description}, instructor_id = #{req.instructorId} WHERE course_id = #{courseId} ")
    Courses updateCourse(@Param("courseId")Integer courseId, @Param("req")CourseRequest updatedCourse);

    @ResultMap("courseMapper")
    @Select("DELETE FROM courses WHERE course_id = #{courseId}")
    void deleteCourse(@Param("courseId")Integer courseId);
}
