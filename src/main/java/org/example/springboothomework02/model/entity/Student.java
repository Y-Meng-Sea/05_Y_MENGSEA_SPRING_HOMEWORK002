package org.example.springboothomework02.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Course> courses;
}
