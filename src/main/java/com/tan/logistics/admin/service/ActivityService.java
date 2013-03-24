package com.tan.logistics.admin.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tan.logistics.admin.model.Activity;

@Service("activityService")
@Transactional
public class ActivityService 
{
		private EntityManager entityManager;
	    @PersistenceContext
	    public void setEntityManager(EntityManager entityManager) {
	        this. entityManager = entityManager;
	    }
	    
		public List<Activity> getAll() {
			
			// Create a JPA query
			Query query  = entityManager.createQuery("FROM Activity");			
			// Retrieve all	
			return query.getResultList();
		}
 
		public Activity get(Integer id ) {
			
			// Retrieve existing person
			// Create a JPA query
			Activity activity = (Activity)entityManager.createQuery("FROM Activity as act WHERE act.id=:id").setParameter("id",id).getSingleResult();
			
			return activity;
		}
		public List<Activity> getSubActivities(Integer parentId, Integer activityId) {
			
			// Create a JPA query
			Query query  = entityManager.createQuery("FROM Activity where parentid="+parentId+" and id="+activityId);
			
			// Retrieve all	
			return query.getResultList();
		}
		
		public List<Activity> getParentActivities() {
			
			// Create a JPA query
			Query query  = entityManager.createQuery("FROM Activity where level=1");
			
			// Retrieve all	
			return query.getResultList();
		}
		
		public void deleteChildActivities(Integer parentActivityId) {
			
			Query query = entityManager.createQuery("delete from Activity where parentId = :id") 
					.setParameter("id", parentActivityId);
					
			// Delete all
			query.executeUpdate();
			
		}
		
		public void add(Activity activity) {
			// Persists to db
			entityManager.persist(activity);
		}

	    public void delete(Integer id) {
	    
	    	Activity activity = entityManager.find(Activity.class, id);
	        if (activity != null) {
	        	entityManager.remove(activity);
	        }
	    }
	    
	    /**
		 * Edits an existing Location Coordinate
		 */
		public void edit(Activity activity) {
			// Retrieve existing person via id
			Activity existingActivity = this.get(activity.getId());
			System.out.println("loc cod id" + existingActivity.getId());
			// Assign updated values to this person
			existingActivity.setActivity(activity.getActivity());
			existingActivity.setLevel(activity.getLevel());
			existingActivity.setParentId(activity.getParentId());
			//save update
			entityManager.merge(existingActivity);
			
		}

	
}
