package com.raphael.employeemanager.service;

import com.raphael.employeemanager.exception.UserNotFoundException;
import com.raphael.employeemanager.model.Employee;
import com.raphael.employeemanager.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Employee> searchEmployeesWithKeyword(String keyword){
        return employeeRepository.findAll()
                .stream()
                .filter(employee -> employee.getName().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User with id "+id+" is not found"));
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
         employeeRepository.deleteEmployeeById(id);
    }


}
