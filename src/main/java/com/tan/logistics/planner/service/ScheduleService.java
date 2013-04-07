package com.tan.logistics.planner.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.tan.logistics.planner.model.Schedule;

@Service("scheduleService")
@Transactional
public class ScheduleService 
{

	
	
	private EntityManager em;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
        
  
    public void add(Person person) {
        em.persist(person);
    }


    public List<Person> getAll() {
        CriteriaQuery<Schedule> s = em.getCriteriaBuilder().createQuery(Schedule.class);
        Root<Schedule> from =s.from(Schedule.class);
        s.orderBy(em.getCriteriaBuilder().asc(from.get("scheduleName")));
        return em.createQuery(s).getResultList();
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
			
		// Save updates
		em.merge(existingPerson);
	}

	  public Person get(Integer id)
	    {
	    	
	    	Person person = (Person) em.createQuery("from Person p where p.id =:id").setParameter("id", id).getSingleResult();
	    	return person;
	    }
}
