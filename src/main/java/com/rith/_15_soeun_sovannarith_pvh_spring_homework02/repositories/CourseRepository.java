package com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories;


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
}
