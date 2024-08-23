package com.osama.project.school_rest_api.dao;

import com.osama.project.school_rest_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
