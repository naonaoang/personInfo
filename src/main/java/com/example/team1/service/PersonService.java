package com.example.team1.service;

import com.example.team1.DAO.Dao.EmployeeDao;
import com.example.team1.DAO.Dao.PersonDao;
import com.example.team1.domain.ContactDomain;
import com.example.team1.domain.PersonDomain;
import com.example.team1.domain.UpdatePersonInfo;
import com.example.team1.entity.Employee;
import com.example.team1.entity.Person;
import com.example.team1.exception.PersonInfoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public Person findPersonById(Integer id){
        Optional<Person> optional = Optional.ofNullable(personDao.getPersonById(id));
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Transactional
    public PersonDomain findPersonInfoById(Person person){
        if(person != null){
            PersonDomain personDomain = new PersonDomain();
            personDomain.setFirstName(person.getFirstName());
            personDomain.setLastName(person.getLastName());
            personDomain.setAvatar(employeeDao.getEmployeeByPersonId(person).getAvatar());
            personDomain.setSsn(person.getSsn());
            personDomain.setDob(person.getDOB());
            return personDomain;
        }
        return null;
    }

    @Transactional
    public Person findPersonByName(String firstName, String lastName){
        return personDao.getPersonByName(firstName, lastName);
    }

    @Transactional
    public Person updateInfo(UpdatePersonInfo updatePersonInfo){
        Person curPerson = personDao.getPersonById(updatePersonInfo.getId());
        if(curPerson==null){
            throw new PersonInfoNotFoundException("person with id: "+updatePersonInfo.getId()+"not found");
        }
        Employee employee = employeeDao.getEmployeeByPersonId(curPerson);
        if(employee==null){
            throw new PersonInfoNotFoundException("employee with person id: "+updatePersonInfo.getId()+" not found");
        }
        curPerson.setFirstName(updatePersonInfo.getFirstName());
        curPerson.setLastName(updatePersonInfo.getLastName());
        curPerson.setDOB(updatePersonInfo.getDob());
        curPerson.setSsn(updatePersonInfo.getSsn());
        curPerson.setGender(updatePersonInfo.getGender());
        curPerson.setMiddleName(updatePersonInfo.getMiddleName());
        employee.setAvatar(updatePersonInfo.getAvatar());
        employee.setDriverLicense(updatePersonInfo.getDriverLicense());
        employee.setDriverLicenseExpirationDate(updatePersonInfo.getDriverLicense_ExpirationDate());
        employeeDao.save(employee);
        return personDao.saveInfo(curPerson);
    }

    @Transactional
    public Person updateInfoWithGivenId(UpdatePersonInfo updatePersonInfo, Integer personId){
        Person curPerson = personDao.getPersonById(personId);
        if(curPerson==null){
            throw new PersonInfoNotFoundException("person with id: "+updatePersonInfo.getId()+"not found");
        }
        Employee employee = employeeDao.getEmployeeByPersonId(curPerson);
        if(employee==null){
            throw new PersonInfoNotFoundException("employee with person id: "+updatePersonInfo.getId()+" not found");
        }
        curPerson.setFirstName(updatePersonInfo.getFirstName());
        curPerson.setLastName(updatePersonInfo.getLastName());
        curPerson.setDOB(updatePersonInfo.getDob());
        curPerson.setSsn(updatePersonInfo.getSsn());
        curPerson.setGender(updatePersonInfo.getGender());
        curPerson.setMiddleName(updatePersonInfo.getMiddleName());
        employee.setAvatar(updatePersonInfo.getAvatar());
        employee.setDriverLicense(updatePersonInfo.getDriverLicense());
        employee.setDriverLicenseExpirationDate(updatePersonInfo.getDriverLicense_ExpirationDate());
        employeeDao.save(employee);
        return personDao.saveInfo(curPerson);
    }

    @Transactional
    public Person updateContact(ContactDomain contactDomain, Integer personId){
        Person curPerson = personDao.getPersonById(personId);
        if(curPerson==null){
            return null;
        }
        curPerson.setCellPhone(contactDomain.getCellPhone());
        curPerson.setAlternatePhone(contactDomain.getWorkPhone());
        curPerson.setEmail(contactDomain.getEmail());
        return personDao.saveInfo(curPerson);
    }
}
