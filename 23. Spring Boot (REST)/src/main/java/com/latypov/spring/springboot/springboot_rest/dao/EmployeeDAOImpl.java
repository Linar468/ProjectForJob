package com.latypov.spring.springboot.springboot_rest.dao;


import com.latypov.spring.springboot.springboot_rest.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;
    @Override

    public List<Employee> getAllEmployees() {
        /*Session session = entityManager.unwrap(Session.class);
        //List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;*/

        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        /*Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);*/
        Employee newEmp = entityManager.merge(employee);
        employee.setId(newEmp.getId());
    }

    @Override
    public Employee getEmployee(int id) {
        /*Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);*/
        Employee employee = entityManager.find(Employee.class, id);
        return employee ;
    }

    @Override
    public void deleteEmployee(int id) {
        /*Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("delete from Employee " +
                "where id =: employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();*/
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
