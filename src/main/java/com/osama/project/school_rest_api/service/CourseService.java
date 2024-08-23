package com.osama.project.school_rest_api.service;

import com.osama.project.school_rest_api.dao.CourseRepository;
import com.osama.project.school_rest_api.entity.Course;
import com.osama.project.school_rest_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CrudService<Course,Integer> {


    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        Optional<Course> result = courseRepository.findById(id);
        Course course = null;

        if(result.isPresent())
            course = result.get();
        else
            throw new RuntimeException("Did not find course with id - " + id);

        return course;
    }

    @Override
    public Course save(Course entity) {
        return courseRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        courseRepository.deleteById(id);
    }
}
