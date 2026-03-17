package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.Impl;

import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.Entity.Instructor;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories.InstructorRepository;
import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public List<Instructor> getAllInstructor(Integer page, Integer size) {
        Integer offset = size * (page - 1) ;
        return instructorRepository.getAllInstructor(offset, size);
    }

    @Override
    public Instructor getInstructorById(Integer instructorId) {
        return instructorRepository.getInstructorById(instructorId);
    }
}
