package org.example.springboothomework02.serevice;

import org.example.springboothomework02.model.dto.request.StudentRequest;
import org.example.springboothomework02.model.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    Student addStudent(StudentRequest studentRequest);

    Student getStudentById(Integer id);
}
