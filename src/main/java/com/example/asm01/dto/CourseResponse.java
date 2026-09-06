package com.example.asm01.dto;

import com.example.asm01.model.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {

    private Long id;
    private String title;
    private String status;
    private Long instructorId;

    public static CourseResponse fromEntity(Course course) {
        return new CourseResponse(
                course.getId(),
                course.getTitle(),
                course.getStatus(),
                course.getInstructorId()
        );
    }
}