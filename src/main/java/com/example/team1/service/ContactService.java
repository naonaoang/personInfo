package com.example.team1.service;

import com.example.team1.DAO.Dao.ContactDao;
import com.example.team1.domain.AddressDomain;
import com.example.team1.domain.EmergencyContactDomain;
import com.example.team1.entity.Address;
import com.example.team1.entity.Contact;
import com.example.team1.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactDao contactDao;

    @Transactional
    public List<EmergencyContactDomain> getEmergencyByPersonId(Person person){
        List<EmergencyContactDomain> domainList = new ArrayList<>();
        List<Contact> contacts = contactDao.getContactByPersonId(person);
        if(contacts!=null && contacts.size()>0){
            for(Contact contact : contacts){
                if(contact.getIsEmergency()){
                    EmergencyContactDomain emergencyContactDomain =
                            new EmergencyContactDomain(person.getId(),
                                    contact.getName(),
                                    contact.getPhone(),
                                    contact.getAddress(),
                                    contact.getRelationship(),
                                    contact.getTitle(),
                                    contact.getId(),
                                    contact.getIsReference(),
                                    contact.getIsEmergency());
                    domainList.add(emergencyContactDomain);
                }
            }
        }
        return domainList;
    }

    @Transactional
    public void updateEmergency(EmergencyContactDomain emergencyContactDomain, Person person){
        List<Contact> contacts = contactDao.getContactByPersonId(person);
        if(contacts!=null && !contacts.isEmpty() && emergencyContactDomain!=null){
            Contact contact = contacts.get(0);
            contact.setIsEmergency(true);
            contact.setName(emergencyContactDomain.getName());
            contact.setAddress(emergencyContactDomain.getAddress());
            contact.setPhone(emergencyContactDomain.getPhone());
            contactDao.updateContact(contact);
        }

    }

    @Transactional
    public void addNewContact(EmergencyContactDomain emergencyContactDomain, Person person){
        Contact contact = new Contact();
        contact.setPerson(person);
        contact.setAddress(emergencyContactDomain.getAddress());
        contact.setPhone(emergencyContactDomain.getPhone());
        contact.setName(emergencyContactDomain.getName());
        contact.setIsEmergency(true);
        contactDao.addContact(contact);
    }
}
