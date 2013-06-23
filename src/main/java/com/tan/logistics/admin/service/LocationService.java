package com.tan.logistics.admin.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tan.logistics.admin.model.Location;

@Service("locationService")
@Transactional
public class LocationService {

	private EntityManager entityManager;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


	public void add(Location location) {
		entityManager.persist(location);
		
	}

	
	public List<Location> getAll() {
	CriteriaQuery<Location> c = entityManager.getCriteriaBuilder().createQuery(Location.class);
	Root<Location> from = c.from(Location.class);
	c.orderBy(entityManager.getCriteriaBuilder().asc(from.get("locName")));
	return entityManager.createQuery(c).getResultList();
	}


    public void delete(Integer id) {
        Location location = entityManager.find(Location.class, id);
        if (null != location) {
            entityManager.remove(location);
        }
    }

	/**
	 * Retrieves a single credit card
	 */
	public Location get(Integer id) {

		Location location = (Location) entityManager.createQuery("from Location l where l.id = :id")
    		.setParameter("id", id).getSingleResult();

		return location;
	}
	
	/**
	 * Edits an existing person
	 */
	public void edit(Location location) {

		Location existingLocation = this.get(location.getId());
		
		existingLocation.setLocType(location.getLocType());
		existingLocation.setLocName(location.getLocName());
		existingLocation.setLocCountry(location.getLocCountry());
	
		entityManager.merge(existingLocation);
	}

}
