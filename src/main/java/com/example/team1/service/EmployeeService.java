package com.example.team1.service;

import com.example.team1.DAO.Dao.EmployeeDao;
import com.example.team1.DAO.Dao.VisaDao;
import com.example.team1.domain.EmployeeDomain;
import com.example.team1.entity.Employee;
import com.example.team1.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public Employee getEmployeeById(Integer id){
        return employeeDao.getEmployeeById(id);
    }

    @Transactional
    public Employee getEmployeeByPersonId(Person person){
        Optional<Employee> optional = Optional.ofNullable(employeeDao.getEmployeeByPersonId(person));
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Transactional
    public EmployeeDomain getEmployeeInfoByPersonId(Person person){
        Optional<Employee> optional = Optional.ofNullable(employeeDao.getEmployeeByPersonId(person));
        if(optional.isPresent()){
            Employee employee = optional.get();
            return new EmployeeDomain(employee.getVisaStatus().getVisaType(),
                    employee.getTitle(),
                    employee.getStartDate(),
                    employee.getEndDate(),
                    employee.getVisaStartDate(),
                    employee.getVisaEndDate());
        }
        return null;
    }

    @Transactional
    public Employee updateEmployee(EmployeeDomain employeeDomain, Person person){
        Employee employee = getEmployeeByPersonId(person);
        employee.setEndDate(employeeDomain.getEndDate());
        employee.setStartDate(employeeDomain.getStartDate());
        employee.getVisaStatus().setVisaType(employeeDomain.getVisaType());
        employee.setVisaStartDate(employeeDomain.getVisaStartDate());
        employee.setVisaEndDate(employeeDomain.getVisaEndDate());
        employee.setTitle(employeeDomain.getTitle());
        return employeeDao.save(employee);
    }

    @Transactional
    public void addEmployee(EmployeeDomain employeeDomain, Person person){
        Employee employee = new Employee();
        employee.setPerson(person);
        employee.setAvatar(employee.getAvatar());
        employee.setTitle(employeeDomain.getTitle());
    }
}
