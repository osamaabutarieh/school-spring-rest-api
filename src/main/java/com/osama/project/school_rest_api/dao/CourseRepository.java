package com.osama.project.school_rest_api.dao;

import com.osama.project.school_rest_api.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
