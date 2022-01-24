package com.example.team1.DAO.Dao;

import com.example.team1.DAO.AbstractHibernateDao;
import com.example.team1.entity.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonDao extends AbstractHibernateDao<Person> {

    public PersonDao(){
        setClazz(Person.class);
    }

    public Person getPersonById(Integer id){
        return findById(id);
    }

    public Person getPersonByName(String firstName, String lastName){
        Session session = getCurrentSession();
        Query selectPersonByName = session.createQuery("FROM Person p " +
                "where p.firstName = :firstName and p.lastName = :lastName");
        selectPersonByName.setParameter("firstName", firstName);
        selectPersonByName.setParameter("lastName", lastName);
        List<Person> persons = (List<Person>) selectPersonByName.getResultList();
        return persons==null?null:persons.get(0);
    }

    public Person saveInfo(Person person){
        return merge(person);
    }

    public void addPerson(Person person){
        persist(person);
    }
}
