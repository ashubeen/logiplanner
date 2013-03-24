package com.tan.logistics.admin.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tan.logistics.admin.model.Company;
import com.tan.logistics.admin.model.Vessel;

@Service("vesselService")
@Transactional
public class VesselService {

private EntityManager em;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

	public void add(Vessel vessel) {
		em.persist(vessel);
		
	}

	public List<Vessel> getAll() {
	CriteriaQuery<Vessel> c = em.getCriteriaBuilder().createQuery(Vessel.class);
	Root<Vessel> from = c.from(Vessel.class);
	c.orderBy(em.getCriteriaBuilder().asc(from.get("vesselName")));
	return em.createQuery(c).getResultList();
	}

   public void delete(Integer id) {
       Vessel vessel = em.find(Vessel.class, id);
       if (null != vessel) {
           em.remove(vessel);
       }
   }
	
	public void edit(Vessel vessel) {

	 	Vessel existingVessel = this.get(vessel.getId());
		
	 	existingVessel.setBaseLocation(vessel.getBaseLocation());
	 	existingVessel.setImoNum(vessel.getImoNum());
	 	existingVessel.setVesselName(vessel.getVesselName());
	 	//TODO: Add rest of the colums
		em.merge(existingVessel);
	}
	
	
	public Vessel get(Integer id){
		

		Vessel vessel = (Vessel) em.createQuery("from Vessel v where v.id = :id")
    		.setParameter("id", id).getSingleResult();

		return vessel;
	}
	

}

