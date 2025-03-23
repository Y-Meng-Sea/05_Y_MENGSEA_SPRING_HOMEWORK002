package org.example.springboothomework02.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springboothomework02.model.entity.Course;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Course> coursesId;
}
