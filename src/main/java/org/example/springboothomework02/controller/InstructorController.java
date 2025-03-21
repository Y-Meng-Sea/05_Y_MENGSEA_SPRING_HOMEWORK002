package org.example.springboothomework02.controller;

import lombok.Builder;
import org.example.springboothomework02.model.dto.request.InstructorRequest;
import org.example.springboothomework02.model.dto.respones.ApiResponse;
import org.example.springboothomework02.model.entity.Instructor;
import org.example.springboothomework02.serevice.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructor(){
        ApiResponse<List<Instructor>> response = ApiResponse.<List<Instructor>>builder()
                .message("get all instructor successfully")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(instructorService.getAllinstructor())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> addInstructor(@RequestBody InstructorRequest instructorRequest ){
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("Add instructor success")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(instructorService.addInstructor(instructorRequest))
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructor(@PathVariable("instructor_id") Integer instructor_id ){
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("delete instructor success")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(instructorService.deleteInstructor(instructor_id))
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable("instructor_id") Integer id ,@RequestBody InstructorRequest instructorRequest ){
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("Update instructor success")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(instructorService.updateInstructor(id,instructorRequest))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{instructor_id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable("instructor_id") Integer id ){
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("Update instructor success")
                .success(true)
                .status(HttpStatus.OK)
                .timeStamp(LocalDateTime.now())
                .payload(instructorService.getInstructorById(id))
                .build();
        return ResponseEntity.ok(response);
    }
}
