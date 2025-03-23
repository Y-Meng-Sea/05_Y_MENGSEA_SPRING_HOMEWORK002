package org.example.springboothomework02.serevice.serviceImpl;

import org.example.springboothomework02.model.dto.request.StudentRequest;
import org.example.springboothomework02.model.entity.Student;
import org.example.springboothomework02.repository.StudentRepository;
import org.example.springboothomework02.serevice.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    @Override
    public Student addStudent(StudentRequest studentRequest){
        return studentRepository.addAllStudent(studentRequest);
    }
}
