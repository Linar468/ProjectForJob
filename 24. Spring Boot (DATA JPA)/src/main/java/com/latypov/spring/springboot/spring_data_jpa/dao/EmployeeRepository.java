package com.latypov.spring.springboot.spring_data_jpa.dao;

import com.latypov.spring.springboot.spring_data_jpa.entity.Employee;
import org.hibernate.cfg.annotations.reflection.JPAMetadataProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public List<Employee> findAllByName(String name);

}
