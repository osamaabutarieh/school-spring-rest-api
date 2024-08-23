package com.osama.project.school_rest_api.service;

import com.osama.project.school_rest_api.dao.StudentRepository;
import com.osama.project.school_rest_api.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements CrudService<Student,Integer> {


    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        Optional<Student> result = studentRepository.findById(id);
        Student student =null;
        if(result.isPresent())
            student = result.get();
        else
            throw new RuntimeException("Did not find student with id - " + id);

        return student;
    }

    @Override
    public Student save(Student entity) {
        return studentRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }
}
