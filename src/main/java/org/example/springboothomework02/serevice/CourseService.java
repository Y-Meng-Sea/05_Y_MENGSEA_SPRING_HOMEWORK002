package org.example.springboothomework02.serevice;

import org.example.springboothomework02.model.dto.request.CourseRequest;
import org.example.springboothomework02.model.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    // get all course
    List<Course> getAllCourses();

    //add course
    Course addCourse(CourseRequest courseRequest);

    //get courses by id
    Course getCourseById();

    //update course by id
    Course updateCourse();

    // delete course by id
    Course deleteCourse();
}
