package org.example.springboothomework02.controller;

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
}
