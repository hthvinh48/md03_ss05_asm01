package com.example.asm01.service;

import com.example.asm01.dto.CourseResponse;
import com.example.asm01.dto.CourseResponseV2;
import com.example.asm01.dto.PageResponse;
import com.example.asm01.model.CourseStatus;
import org.springframework.data.domain.Sort;

public interface CourseService {

    PageResponse<CourseResponse> getPagedCourses(
            int page,
            int size,
            String sortBy,
            Sort.Direction direction
    );

    PageResponse<CourseResponse> getPagedCoursesByStatus(
            int page,
            int size,
            String sortBy,
            Sort.Direction direction,
            CourseStatus status
    );

    PageResponse<CourseResponseV2> getPagedCoursesByStatusV2(
            int page,
            int size,
            String sortBy,
            Sort.Direction direction,
            CourseStatus status
    );
}