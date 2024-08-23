package com.osama.project.school_rest_api.service;

import com.osama.project.school_rest_api.dao.EmployeeRepository;
import com.osama.project.school_rest_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements CrudService<Employee,Integer>{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;

        if(result.isPresent())
            employee = result.get();
        else
            throw new RuntimeException("Did not find employee with id - " + id);

        return employee;
    }

    @Override
    public Employee save(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }
}
