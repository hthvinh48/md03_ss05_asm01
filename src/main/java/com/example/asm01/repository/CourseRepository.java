package com.example.asm01.repository;

import com.example.asm01.dto.CourseResponseV2;
import com.example.asm01.model.Course;
import com.example.asm01.model.CourseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.status = :status")
    Page<Course> findAllByStatus(
            @Param("status") CourseStatus status,
            Pageable pageable
    );

    @Query("""
            SELECT new com.example.asm01.dto.CourseResponseV2(
                c.id,
                c.title,
                c.status
            )
            FROM Course c
            WHERE c.status = :status
            """)
    Page<CourseResponseV2> findAllByStatusProjection(
            @Param("status") CourseStatus status,
            Pageable pageable
    );
}