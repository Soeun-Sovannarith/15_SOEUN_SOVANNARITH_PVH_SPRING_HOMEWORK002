package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.InstructorRequest;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorService {
    List<Instructor> getAllInstructor(Integer page, Integer size);

    Instructor getInstructorById(Integer instructorId);

    Instructor createInstructor(InstructorRequest newInstructor);

    Instructor updateInstructor(Integer instructorId, InstructorRequest updatedInstructor);

    Instructor deleteInstructor(Integer instructorId);
}
