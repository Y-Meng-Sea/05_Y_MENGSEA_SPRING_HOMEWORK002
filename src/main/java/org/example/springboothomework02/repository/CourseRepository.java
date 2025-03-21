package org.example.springboothomework02.repository;

import org.apache.ibatis.annotations.*;
import org.example.springboothomework02.model.dto.request.CourseRequest;
import org.example.springboothomework02.model.entity.Course;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("""
        SELECT * FROM courses;
    """)
    @Results(id = "courserMapper", value = {
            @Result(property = "id", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "org.example.springboothomework02.repository.InstructorRepository.getInstructorById")),
    })
    List<Course> getAllCourses();


    @Select("""
        INSERT INTO courses (course_name, description,instructor_id) 
        VALUES (#{request.courseName},#{request.description},#{request.instructorId}) 
        RETURNING *
    """)
    @ResultMap("courserMapper")
    Course addCourse(@Param("request") CourseRequest courseRequest);
}
