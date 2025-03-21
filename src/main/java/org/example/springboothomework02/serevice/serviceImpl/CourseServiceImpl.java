package org.example.springboothomework02.serevice.serviceImpl;

import org.example.springboothomework02.model.dto.request.CourseRequest;
import org.example.springboothomework02.model.entity.Course;
import org.example.springboothomework02.repository.CourseRepository;
import org.example.springboothomework02.serevice.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        System.out.println(courseRepository.getAllCourses());
        return courseRepository.getAllCourses();
    }

    @Override
    public Course addCourse(CourseRequest courseRequest) {
        return courseRepository.addCourse(courseRequest);
    }

    @Override
    public Course getCourseById() {
        return null;
    }

    @Override
    public Course updateCourse() {
        return null;
    }

    @Override
    public Course deleteCourse() {
        return null;
    }
}
