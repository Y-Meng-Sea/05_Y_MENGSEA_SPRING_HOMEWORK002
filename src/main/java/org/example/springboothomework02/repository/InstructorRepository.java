package org.example.springboothomework02.repository;

import org.apache.ibatis.annotations.*;
import org.example.springboothomework02.model.dto.request.InstructorRequest;
import org.example.springboothomework02.model.entity.Instructor;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Select("""
        SELECT * FROM instructors
    """)
    @Results( id= "instructorsMapper", value = {
            @Result(property = "id", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name")
    })
    List<Instructor> getAllInstructor();


    @Insert("""
        INSERT INTO instructors (instructor_name, email) 
        VALUES (#{request.instructorName}, #{request.email}) 
        RETURNING *
    """)
    @ResultMap("instructorsMapper")
    Instructor addInstructor(@Param("request") InstructorRequest instructorRequest);

    @Select("""
        DELETE FROM instructors WHERE instructor_id = #{instructor_id} RETURNING *
    """)
    @ResultMap("instructorsMapper")
    Instructor deleteInstructor(@Param("instructor_id") Integer instructor_id);

    @Select("""
        UPDATE instructors
        SET instructor_name = #{request.instructorName},
            email = #{request.email}
        WHERE instructor_id = #{id}
        RETURNING *;
    """)
    @ResultMap("instructorsMapper")
    Instructor updateInstructor( @Param("id") Integer instructor_id, @Param("request") InstructorRequest instructorRequest);

    @Select("""
        SELECT * FROM instructors WHERE instructor_id = #{id}
    """)
    @ResultMap("instructorsMapper")
    Instructor getInstructorById(@Param("id") Integer id);

}
