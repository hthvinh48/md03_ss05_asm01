package com.example.asm01.service;

import com.example.asm01.dto.CourseResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface CourseService {

    Page<CourseResponse> getPagedCourses(
            int page,
            int size,
            String sortBy,
            Sort.Direction direction
    );
}