package com.example.team1.DAO.Dao;

import com.example.team1.DAO.AbstractHibernateDao;
import com.example.team1.entity.Address;
import com.example.team1.entity.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

@Repository
public class AddressDao extends AbstractHibernateDao<Address> {

    public AddressDao(){
        setClazz(Address.class);
    }

    public Address getAddressById(Integer id){
        return findById(id);
    }

    public List<Address> getAddressListByPersonId(Person person){
        Session session = getCurrentSession();
        Query getAddressesByPersonId = session.createQuery("FROM Address a WHERE a.person.id = :id");
        getAddressesByPersonId.setParameter("id",person.getId());
        List<Address> addressList = (List<Address>) getAddressesByPersonId.getResultList();
        return addressList;
    }

    public Address updateAddress(Address address){
        return merge(address);
    }

    public void addNewAddress(Address address){
        persist(address);
    }
}
