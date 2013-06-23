package com.tan.logistics.admin.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tan.logistics.admin.model.Location;
import com.tan.logistics.admin.model.LocationCoordinates;

@Service("locCoordinatesService")
@Transactional
public class LocationCoordinatesService  {

	private EntityManager entityManager;
	
	@Resource(name = "locationService")
	private LocationService locationService;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
	

	
	public void add(Integer locationId,
			LocationCoordinates locCoordinates) {

		Location existingLocation = locationService.get(locationId);

		locCoordinates.setLocation(existingLocation);
		
		//entityManager.merge(locCoordinates);
		entityManager.persist(locCoordinates);
		

	}

	public List<LocationCoordinates> getAll(Integer locationId) {
		
		Query query = entityManager.createQuery("FROM LocationCoordinates where location.id = " + locationId);
    	
    	return query.getResultList();
		/*CriteriaQuery<LocationCoordinates> c = entityManager.getCriteriaBuilder().createQuery(LocationCoordinates.class);
		Root<LocationCoordinates> from = c.from(LocationCoordinates.class);
		c.where("locationId=" + locationId);
		c.orderBy(entityManager.getCriteriaBuilder().asc(from.get("locCordinatesId")));
		return entityManager.createQuery(c).getResultList();*/
	}



	public void delete(Integer id) {
		//LocationCoordinates locCoordinates = entityManager.find(LocationCoordinates.class, locationId);
		LocationCoordinates locCoordinates = this.get(id);
				
	        if (null != locCoordinates) {
	            entityManager.remove(locCoordinates);
	        }
	}

	/**
	 * Deletes all credit cards based on the person's id
	 */
	public void deleteAll(Integer locationId) {
		//logger.debug("Deleting existing credit cards based on person's id");
		
		// Create a JPA query
		Query query = entityManager.createQuery("delete from LocationCoordinates where location.id = :id") 
		.setParameter("id", locationId);
		
		// Delete all
		query.executeUpdate();
		
	}
	
	/**
	 * Retrieves a single credit card
	 */
	public LocationCoordinates get(Integer id) {
		
		// Retrieve existing credit card
		LocationCoordinates locCoordinates = (LocationCoordinates) entityManager.createQuery("from LocationCoordinates lc where lc.id = :id")
    		.setParameter("id", id).getSingleResult();

		// Persists to db
		return locCoordinates;
	}
 
	/**
	 * Edits an existing Location Coordinate
	 */
	public void edit(LocationCoordinates locCoordinates) {
		// Retrieve existing person via id
		LocationCoordinates existingLocCoordinates = this.get(locCoordinates.getId());
		
		// Assign updated values to this person
		existingLocCoordinates.setLocLongitute(locCoordinates.getLocLongitute());
		existingLocCoordinates.setLocLatitude(locCoordinates.getLocLatitude());
		existingLocCoordinates.setLocDecimalX(locCoordinates.getLocDecimalX());
		existingLocCoordinates.setLocDecimalY(locCoordinates.getLocDecimalY());

		// Save updates
		entityManager.merge(existingLocCoordinates);
		
	}

		
}
