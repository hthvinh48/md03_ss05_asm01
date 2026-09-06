package com.example.asm01.service;

import com.example.asm01.dto.CourseResponse;
import com.example.asm01.dto.PageResponse;
import org.springframework.data.domain.Sort;

public interface CourseService {

    PageResponse<CourseResponse> getPagedCourses(
            int page,
            int size,
            String sortBy,
            Sort.Direction direction
    );
}