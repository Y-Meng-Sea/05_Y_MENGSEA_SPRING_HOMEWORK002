package org.example.springboothomework02.serevice.serviceImpl;

import org.example.springboothomework02.model.dto.request.InstructorRequest;
import org.example.springboothomework02.model.entity.Instructor;
import org.example.springboothomework02.repository.InstructorRepository;
import org.example.springboothomework02.serevice.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private  final InstructorRepository instructorRepository;


    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllinstructor() {
        return instructorRepository.getAllInstructor();
    }

    @Override
    public Instructor addInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.addInstructor(instructorRequest);
    }

    @Override
    public Instructor deleteInstructor(Integer instructor_id) {
        return instructorRepository.deleteInstructor(instructor_id);
    }

    @Override
    public Instructor updateInstructor(Integer instructor_id, InstructorRequest instructorRequest) {
        return instructorRepository.updateInstructor(instructor_id, instructorRequest);
    }

    @Override
    public Instructor getInstructorById(Integer id) {
        return instructorRepository.getInstructorById(id);
    }
}
