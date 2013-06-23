package com.tan.logistics.admin.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tan.logistics.admin.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

@Service("personService")
@Transactional
public class PersonService {

	private EntityManager em;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
        
  
    public void add(Person person) {
        em.persist(person);
    }


    public List<Person> getAll() {
        CriteriaQuery<Person> c = em.getCriteriaBuilder().createQuery(Person.class);
        Root<Person> from = c.from(Person.class);
        c.orderBy(em.getCriteriaBuilder().asc(from.get("lastName")));
        return em.createQuery(c).getResultList();
    }

    public void delete(Integer id) {
        Person person = em.find(Person.class, id);
        if (null != person) {
            em.remove(person);
        }
    }
    
	/**
	 * Edits an existing person
	 */
	public void edit(Person person) {

		// Retrieve existing person via id
		Person existingPerson = this.get(person.getId());
		existingPerson.setCountryOfResidence(person.getCountryOfResidence());
		existingPerson.setDob(person.getDob());
		existingPerson.setFirstName(person.getFirstName());
		existingPerson.setLastName(person.getLastName());
		existingPerson.setMiddleName(person.getMiddleName());
		existingPerson.setNationality(person.getNationality());
		existingPerson.setCompanyId(person.getCompanyId());
		existingPerson.setTitleId(person.getTitleId());
			
		// Save updates
		em.merge(existingPerson);
	}

	  public Person get(Integer id)
	    {
	    	
	    	Person person = (Person) em.createQuery("from Person p where p.id =:id").setParameter("id", id).getSingleResult();
	    	return person;
	    }
	    
    
}
