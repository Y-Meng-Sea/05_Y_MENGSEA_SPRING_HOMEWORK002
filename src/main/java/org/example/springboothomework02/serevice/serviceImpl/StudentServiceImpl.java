package org.example.springboothomework02.serevice.serviceImpl;

import org.example.springboothomework02.model.dto.request.StudentRequest;
import org.example.springboothomework02.model.entity.Student;
import org.example.springboothomework02.repository.CourseRepository;
import org.example.springboothomework02.repository.StudentRepository;
import org.example.springboothomework02.serevice.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.getAllStudent();
    }

    @Override
    public Student addStudent(StudentRequest studentRequest){
        Student student = studentRepository.addStudent(studentRequest);
        for (Integer courseId : studentRequest.getCoursesId()) {
            courseRepository.addStudentAndCourse(student.getId(), courseId);
        }
        return getStudentById(student.getId());

    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.getStudentById(id);
    }
}
