package com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Instructor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Results(id = "instructorMapper",value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name")

    })
    @Select("Select * from instructors OFFSET #{offset} LIMIT #{size}")
    List<Instructor> getAllInstructor(Integer offset, Integer size);

    @ResultMap("instructorMapper")
    @Select("Select * from instructors where instructor_id = #{instructorId}")
    Instructor getInstructorById(Integer instructorId);
}
