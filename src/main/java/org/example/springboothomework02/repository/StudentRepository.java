package org.example.springboothomework02.repository;

import org.apache.ibatis.annotations.*;
import org.example.springboothomework02.model.dto.request.StudentRequest;
import org.example.springboothomework02.model.entity.Student;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("""
        SELECT
            s.student_id,
            s.student_name,
            s.email,
            s.phone_number,
            c.course_id
        FROM students s
        JOIN student_course sc ON s.student_id = sc.student_id
        JOIN courses c ON sc.courses_id = c.course_id;
        
    """)
    @Results(id= "studentMapper", value = {
            @Result(property = "id" , column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "course_id",many = @Many(select = "org.example.springboothomework02.repository.CourseRepository.getCourseById"))
    })
    List<Student> getAllStudent();


    @Insert("""
        INSERT INTO students(student_name,email,phone_number) VALUES(#{request.studentName},#{request.email},#{request.phoneNumber});
        INSERT INTO student_course(course_id) VALUES (#{request.coursesId})
    """)
    Student addStudent(@Param("request") StudentRequest studentRequest);

}
