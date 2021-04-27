package com.latypov.spring.springboot.springboot_rest.controller;


import com.latypov.spring.springboot.springboot_rest.entity.Employee;
import com.latypov.spring.springboot.springboot_rest.exception_handling.NoSuchEmployeeException;
import com.latypov.spring.springboot.springboot_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee == null){
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEMployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null){
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database");
        }
        employeeService.deleteEmployee(id);
        return "Employee with ID= " + id + " was deleted";
    }
}
