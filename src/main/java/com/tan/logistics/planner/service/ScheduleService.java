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
        
  
    public void add(Schedule schedule) {
        em.persist(schedule);
    }


    public List<Schedule> getAll() {
        CriteriaQuery<Schedule> s = em.getCriteriaBuilder().createQuery(Schedule.class);
        Root<Schedule> from =s.from(Schedule.class);
        s.orderBy(em.getCriteriaBuilder().asc(from.get("scheduleName")));
        return em.createQuery(s).getResultList();
    }

    public void delete(Integer id) {
        Schedule schedule = em.find(Schedule.class, id);
        if (null != schedule) {
            em.remove(schedule);
        }
    }
    
	/**
	 * Edits an existing schedule
	 */
	public void edit(Schedule schedule) {

		// Retrieve existing person via id
		Schedule existingSchedule = this.get(schedule.getId());
	
			
		// Save updates
		em.merge(existingSchedule);
	}

	  public Schedule get(Integer id)
	    {
	    	
		  Schedule schedule = (Schedule) em.createQuery("from Schedule s where s.id =:id").setParameter("id", id).getSingleResult();
	    	return schedule;
	    }
}
