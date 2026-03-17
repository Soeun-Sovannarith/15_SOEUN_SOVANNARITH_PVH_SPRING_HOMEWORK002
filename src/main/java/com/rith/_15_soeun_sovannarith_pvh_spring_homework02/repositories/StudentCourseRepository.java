package com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentCourseRepository {
    @Insert("INSERT INTO student_course (student_id, course_id) VALUES (#{studentId}, #{courseId})")
    void saveStudentCourse(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId);

    @Delete("DELETE FROM student_course WHERE student_id = #{studentId}")
    void deleteStudentCourseByStudentId(Integer studentId);
}
