package com.osama.project.school_rest_api.rest;

import com.osama.project.school_rest_api.entity.Course;
import com.osama.project.school_rest_api.entity.Student;
import com.osama.project.school_rest_api.service.CourseService;
import com.osama.project.school_rest_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRestController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.findAll();
    }

    @GetMapping("/course/{id}")
    public Course getStudentById(@PathVariable int id){
        Course course = courseService.findById(id);

        if (course == null) {
            throw new RuntimeException("Employee id not found - " + course);
        }

        return course;
    }

    @PostMapping("/course")
    public Course addStudent(@RequestBody Course course){
        course.setId(0);
        Course newCourse = courseService.save(course);

        return newCourse;
    }

    @PutMapping("/course")
    public Course updateCourse(@RequestBody Course course){
        Course newCourse = courseService.save(course);

        return newCourse;
    }

    @DeleteMapping("/course/{id}")
    public String deleteCourse(@PathVariable int id){

        Course course = courseService.findById(id);

        if(course == null)
            throw new RuntimeException("Student id not found - " + id);

        courseService.delete(id);
        return "Deleting course id - " + id;
    }
}
