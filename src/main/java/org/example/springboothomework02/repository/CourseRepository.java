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


    @Select("""
        SELECT * FROM courses WHERE course_id=#{id}
    """)
    @ResultMap("courserMapper")
    Course getCourseById(Integer id);

    @Select("""
        DELETE  FROM  courses WHERE course_id=#{id} RETURNING*
    """)
    @ResultMap("courserMapper")
    Course deleteCourse(Integer id);

    @Select("""
        UPDATE courses
        SET course_name = #{request.courseName},
            description = #{request.description},
            instructor_id = #{request.instructorId}
        WHERE course_id = #{id}
        RETURNING *;
    """)
    @ResultMap("courserMapper")
    Course updateCourse(Integer id,@Param("request") CourseRequest courseRequest);
}


