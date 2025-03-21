package org.example.springboothomework02.serevice;

import org.example.springboothomework02.model.dto.request.InstructorRequest;
import org.example.springboothomework02.model.entity.Instructor;

import java.util.List;

public interface InstructorService {
    //get all instructor service
    List<Instructor> getAllinstructor();

    //add instructor
    Instructor addInstructor(InstructorRequest instructorRequest);


    //delete instructor
    Instructor deleteInstructor(Integer instructor_id);

    // update instructor
    Instructor updateInstructor(Integer instructor_id, InstructorRequest instructorRequest);

    //get instructor by id
    Instructor getInstructorById(Integer id);
}
