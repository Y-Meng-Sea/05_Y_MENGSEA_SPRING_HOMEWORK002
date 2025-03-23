package org.example.springboothomework02.controller;

import org.example.springboothomework02.model.dto.request.StudentRequest;
import org.example.springboothomework02.model.dto.respones.ApiResponse;
import org.example.springboothomework02.model.entity.Student;
import org.example.springboothomework02.serevice.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    //get all student
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudent(){
        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .message("get all student success")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(studentService.getAllStudent())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> addStudent(@RequestBody StudentRequest studentRequest){
            ApiResponse<Student> response = ApiResponse.<Student>builder()
                    .message("add student success")
                    .success(true)
                    .status(HttpStatus.OK)
                    .timeStamp(LocalDateTime.now())
                    .payload(studentService.addStudent(studentRequest))
                    .build();
            return ResponseEntity.ok(response);
    }
}
