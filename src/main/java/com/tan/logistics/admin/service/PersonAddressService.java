package com.tan.logistics.admin.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tan.logistics.admin.model.Person;
import com.tan.logistics.admin.model.PersonAddress;

@Service("personAddressService")
@Transactional
public class PersonAddressService {

	private EntityManager entityManager;
	
	@Resource(name="personService")
	private PersonService personService;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this. entityManager = entityManager;
    }
    
    /**
     * 
     * @param personId
     * @return
     */
    public List<PersonAddress> getAll(Integer personId)
    {
    	Query query = entityManager.createQuery("FROM PersonAddress where person.id="+personId);
    	
    	return query.getResultList();
    	
    }

    public List<PersonAddress> getAll()
    {
    	Query query = entityManager.createQuery("FROM PersonAddress");
    	
    	return query.getResultList();
    	
    }
    
    
    public PersonAddress get(Integer id)
    {
    	
    	PersonAddress personAddress = (PersonAddress)entityManager.createQuery("FROM PersonAddress ca WHERE ca.id=:id").setParameter("id", id).getSingleResult();
    	return personAddress;
    }
    
    /**
     * 
     * @param personId
     * @param personAddress
     */
    public void add(Integer personId, PersonAddress personAddress)
    {
    	
    	Person person = personService.get(personId);
    	
    	personAddress.setPerson(person);
    	entityManager.persist(personAddress);
    }
    
    public void delete(Integer id)
    {
    	
    	PersonAddress personAddress = this.get(id);
    	
    	entityManager.remove(personAddress);
    }
    
    
    public void deleteAll(Integer personId)
    {
    	Query query = entityManager.createQuery("DELETE FROM PersonAddress WHERE person.id="+personId);
    	query.executeUpdate();
    	
    }
    
    public void edit(PersonAddress address)
    {
    	PersonAddress existingPersonAddress= this.get(address.getId());
    	
    	existingPersonAddress.setAddress1(address.getAddress1());
    	existingPersonAddress.setAddress2(address.getAddress2());
    	existingPersonAddress.setAddressType(address.getAddressType());
    	existingPersonAddress.setCity(address.getCity());
    	existingPersonAddress.setCountry(address.getCountry());
    	existingPersonAddress.setState(address.getState());
    	existingPersonAddress.setZipCode(address.getZipCode());
    	
    	entityManager.merge(existingPersonAddress);
    	
    	
    	
    	
    }
    
}
