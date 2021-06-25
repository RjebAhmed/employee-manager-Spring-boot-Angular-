package com.employeemanager.manager.services;

import com.employeemanager.manager.model.Employee;
import com.employeemanager.manager.repo.EmployeeRepoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public class EmployeeService {
    private final EmployeeRepoo empRempoo;
    @Autowired
    public EmployeeService(EmployeeRepoo empRempoo) {
        this.empRempoo = empRempoo;
    }
    public Employee addEmployee(Employee empl){
        empl.setEmployeeCode(UUID.randomUUID().toString());
        return empRempoo.save(empl);

    }
    public List<Employee> findAllEmployees(){
        return empRempoo.findAll();
    }
    public Employee updateEmployee(Employee empl){
        return empRempoo.save(empl);
    }
    public void deleteEmployee(Long id){
        empRempoo.deleteById(id);
    }
    public Employee findEmployeeById(Long id){
        return empRempoo.findEmployeeById(id).orElseThrow(()-> new userNotFoundException("User by id"+id+"was not found"));
    }
}
