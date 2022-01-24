package com.example.team1.DAO.Dao;

import com.example.team1.DAO.AbstractHibernateDao;
import com.example.team1.entity.Contact;
import com.example.team1.entity.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ContactDao extends AbstractHibernateDao<Contact> {

    public ContactDao(){
        setClazz(Contact.class);
    }

    public Contact getContactById(Integer id){
        return findById(id);
    }

    public List<Contact> getContactByPersonId(Person person){
        Session session = getCurrentSession();
        Query getContactByPersonId = session.createQuery("FROM Contact c WHERE c.person.id = :id");
        getContactByPersonId.setParameter("id", person.getId());
        List<Contact> contacts = (List<Contact>) getContactByPersonId.getResultList();
        return contacts;
    }

    public void addContact(Contact contact){
        persist(contact);
    }

    public Contact updateContact(Contact contact){
        return merge(contact);
    }
}
