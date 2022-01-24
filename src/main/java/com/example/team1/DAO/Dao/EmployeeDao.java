package com.example.team1.DAO.Dao;

import com.example.team1.DAO.AbstractHibernateDao;
import com.example.team1.entity.Employee;
import com.example.team1.entity.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class EmployeeDao extends AbstractHibernateDao<Employee> {

    public EmployeeDao(){
        setClazz(Employee.class);
    }

    public Employee getEmployeeById(Integer id){
        return findById(id);
    }

    public Employee getEmployeeByPersonId(Person person){
        Session session = getCurrentSession();
        Query findEmployeeByPersonId = session.createQuery("FROM Employee e WHERE e.person.id = :id");
        findEmployeeByPersonId.setParameter("id", person.getId());
        Employee employee = (Employee) findEmployeeByPersonId.getSingleResult();
        return employee;
    }

    public Employee save(Employee employee){
        return merge(employee);
    }

    public void add(Employee employee){
        persist(employee);
    }
}
