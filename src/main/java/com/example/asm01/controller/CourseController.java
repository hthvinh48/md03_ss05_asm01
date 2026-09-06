package com.example.asm01.controller;

import com.example.asm01.dto.CourseResponse;
import com.example.asm01.response.ApiResponse;
import com.example.asm01.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<CourseResponse>>> getCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(defaultValue = "DESC") Sort.Direction direction
    ) {

        Page<CourseResponse> courses = courseService.getPagedCourses(
                page,
                size,
                sortBy,
                direction
        );

        ApiResponse<Page<CourseResponse>> response =
                new ApiResponse<>(
                        true,
                        "Get courses successfully",
                        courses
                );

        return ResponseEntity.ok(response);
    }
}