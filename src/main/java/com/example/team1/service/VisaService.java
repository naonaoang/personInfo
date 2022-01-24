package com.example.team1.service;

import com.example.team1.DAO.Dao.ApplicationWorkflowDAO;
import com.example.team1.DAO.Dao.VisaDao;
import com.example.team1.domain.VisaStatusDomain;
import com.example.team1.entity.ApplicationWorkflow;
import com.example.team1.entity.Employee;
import com.example.team1.entity.Person;
import com.example.team1.entity.VisaStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class VisaService {

    @Autowired
    private VisaDao visaDao;
    @Autowired
    ApplicationWorkflowDAO applicationWorkflowDAO;

    @Transactional
    public VisaStatus getVisaById(Integer id){
        return visaDao.getVisaById(id);
    }

    @Transactional
    public VisaStatusDomain getVisaByPersonId(Person person){
        Optional<VisaStatus> optional = Optional.ofNullable(visaDao.getVisaByPersonId(person));
        if(optional.isPresent()){
            VisaStatus visaStatus = optional.get();
            VisaStatusDomain visaStatusDomain = new VisaStatusDomain(visaStatus.getVisaType(), visaStatus.getActive());
            return visaStatusDomain;
        }
        return null;
    }

    @Transactional
    public VisaStatus updateVisaWithPerson(
            VisaStatusDomain visaStatusDomain,
            Person person){
        Optional<VisaStatus> optional = Optional.ofNullable(visaDao.getVisaByPersonId(person));
        if(optional.isPresent()){
            VisaStatus visaStatus = optional.get();
            visaStatus.setVisaType(visaStatusDomain.getVisaType());
            visaStatus.setActive(visaStatusDomain.getIsActive());
            return visaDao.save(visaStatus);
        }
        return null;
    }

    public ApplicationWorkflow getWorkflowById(int ID){
        try{
            return applicationWorkflowDAO.getWorkflowById(ID);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public ApplicationWorkflow getWorkflowByEmployeeId(int ID){
        try{
            return applicationWorkflowDAO.getWorkflowByEmployeeId(ID);
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }


    public void updateApplicationWorkflow(ApplicationWorkflow applicationWorkflow){
        try {
            applicationWorkflowDAO.updateApplicationWorkflow(applicationWorkflow);
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
