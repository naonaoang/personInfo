package com.example.team1.DAO.Dao;

import com.example.team1.DAO.AbstractHibernateDao;
import com.example.team1.entity.Employee;
import com.example.team1.entity.Person;
import com.example.team1.entity.PersonalDocument;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

@Repository
public class PersonalDocumentDao extends AbstractHibernateDao<PersonalDocument> {
    public PersonalDocumentDao(){
        setClazz(PersonalDocument.class);
    }

    public PersonalDocument getDocumentById(Integer id){
        return findById(id);
    }

    public List<PersonalDocument> getDocsByEmployeeId(Employee employee){
        Session session = getCurrentSession();
        Query getDocsByEmployeeId = session.createQuery("FROM PersonalDocument pd WHERE pd.employee.id = :id");
        getDocsByEmployeeId.setParameter("id", employee.getId());
        List<PersonalDocument> personalDocs = (List<PersonalDocument>) getDocsByEmployeeId.getResultList();
        return personalDocs;
    }

    public void addDocs(PersonalDocument personalDocument){
        persist(personalDocument);
    }

    public PersonalDocument update(PersonalDocument personalDocument){
        return merge(personalDocument);
    }
}
