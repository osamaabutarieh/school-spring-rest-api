package com.osama.project.school_rest_api.rest;

import com.osama.project.school_rest_api.entity.Student;
import com.osama.project.school_rest_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.findAll();
    }

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        Student student = studentService.findById(studentId);

        if (student == null) {
            throw new RuntimeException("Employee id not found - " + student);
        }

        return student;
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        student.setId(0);
        Student newStudent = studentService.save(student);

        return newStudent;
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student){
        Student newStudent = studentService.save(student);

        return newStudent;
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id){

        Student student = studentService.findById(id);

        if(student == null)
            throw new RuntimeException("Student id not found - " + id);

        studentService.delete(id);
        return "Deleting student id - " + id;
    }

}
