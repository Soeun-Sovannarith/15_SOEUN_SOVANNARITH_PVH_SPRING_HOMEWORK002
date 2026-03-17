package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services;


import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Instructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface InstructorService {
    List<Instructor> getAllInstructor(Integer page, Integer size);

    Instructor getInstructorById(Integer instructorId);
}
