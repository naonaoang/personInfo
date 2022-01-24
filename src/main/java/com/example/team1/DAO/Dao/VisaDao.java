package com.example.team1.DAO.Dao;

import com.example.team1.DAO.AbstractHibernateDao;
import com.example.team1.entity.Employee;
import com.example.team1.entity.Person;
import com.example.team1.entity.VisaStatus;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class VisaDao extends AbstractHibernateDao<VisaStatus> {

    public VisaDao(){
        setClazz(VisaStatus.class);
    }

    public VisaStatus getVisaById(Integer id){
        return findById(id);
    }

    public VisaStatus getVisaByPersonId(Person person){
        Session session = getCurrentSession();
        Query getVisaByPersonId = session.createQuery("FROM VisaStatus v WHERE v.person.id = :id");
        getVisaByPersonId.setParameter("id", person.getId());
        VisaStatus visaStatus = (VisaStatus) getVisaByPersonId.getSingleResult();
        return visaStatus;
    }

    public VisaStatus save(VisaStatus visaStatus){
        return merge(visaStatus);
    }

    public void addVisa(VisaStatus visaStatus){
        persist(visaStatus);
    }
}
