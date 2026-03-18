package com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.InstructorRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Instructor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Results(id = "instructorMapper",value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "email", column = "email")

    })
    @Select("Select * from instructors OFFSET #{offset} LIMIT #{size}")
    List<Instructor> getAllInstructor(Integer offset, Integer size);

    @ResultMap("instructorMapper")
    @Select("Select * from instructors where instructor_id = #{instructorId}")
    Instructor getInstructorById(Integer instructorId);


    @ResultMap("instructorMapper")
    @Select("INSERT INTO instructors (instructor_name, email) VALUES (#{req.instructorName}, #{req.email}) RETURNING *")
    Instructor createInstructor(@Param("req") InstructorRequest newInstructor);


    @ResultMap("instructorMapper")
    @Select("UPDATE instructors SET instructor_name = #{req.instructorName}, email = #{req.email} WHERE instructor_id = #{studentId} RETURNING *;")
    Instructor updateInstructor(@Param("studentId")Integer instructorId, @Param("req") InstructorRequest updatedInstructor);


    @ResultMap("instructorMapper")
    @Select("DELETE FROM instructors WHERE instructor_id = #{instructorId}")
    Instructor deleteInstructor(Integer instructorId);
}
