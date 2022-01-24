package com.example.team1.DAO.Dao;

import com.example.team1.entity.ApplicationWorkflow;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ApplicationWorkflowDAO {
    @Autowired
    protected SessionFactory sessionFactory;

    protected final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public ApplicationWorkflow getWorkflowById(int ID){
        Session session = getCurrentSession();
        Query query = session.createQuery("From ApplicationWorkflow a WHERE a.ID = :ID");
        query.setParameter("ID", ID);
        ApplicationWorkflow applicationWorkflow = (ApplicationWorkflow) query.getSingleResult();
        return applicationWorkflow;
    }

    public ApplicationWorkflow getWorkflowByEmployeeId(int ID){
        Session session = getCurrentSession();
        Query query = session.createQuery("From ApplicationWorkflow a WHERE a.employeeID = :ID");
        query.setParameter("ID", ID);
        ApplicationWorkflow applicationWorkflow = (ApplicationWorkflow) query.getSingleResult();
        return applicationWorkflow;
    }

    public void updateApplicationWorkflow(ApplicationWorkflow applicationWorkflow){
        Session session = getCurrentSession();
        session.beginTransaction();
        session.update(applicationWorkflow);
        session.getTransaction().commit();
    }
}