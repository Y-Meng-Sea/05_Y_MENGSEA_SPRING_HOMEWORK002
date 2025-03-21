package org.example.springboothomework02.controller;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.example.springboothomework02.model.dto.request.CourseRequest;
import org.example.springboothomework02.model.dto.respones.ApiResponse;
import org.example.springboothomework02.model.entity.Course;
import org.example.springboothomework02.serevice.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;
    CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    //get all course
    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses(){
        ApiResponse<List<Course>> response = ApiResponse.<List<Course>>builder()
                .message("get all course success")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(courseService.getAllCourses())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> addCourse(@RequestBody CourseRequest courseRequest){
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("add course success")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(courseService.addCourse(courseRequest))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("course-id") Integer id ){
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("get course success")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(courseService.getCourseById(id))
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{course_id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourse(@PathVariable("course_id") Integer id){
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("deleted course success")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(courseService.deleteCourse(id))
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{course_id}")
    public ResponseEntity<ApiResponse<Course>> updateCourse(@PathVariable("course_id") Integer id, @RequestBody CourseRequest courseRequest){
        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .message("update success")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(courseService.updateCourse(id,courseRequest))
                .build();
        return ResponseEntity.ok(response);
    }
}
