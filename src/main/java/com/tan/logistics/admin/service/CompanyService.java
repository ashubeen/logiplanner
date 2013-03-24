package com.tan.logistics.admin.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tan.logistics.admin.model.Company;

@Service("companyService")
@Transactional
public class CompanyService 
{

	private EntityManager entityManager;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this. entityManager = entityManager;
    }
    
    
	public List<Company> getAll() {
		
		// Create a JPA query
		Query query  = entityManager.createQuery("FROM Company");
		
		// Retrieve all	
		return query.getResultList();
	}

	public Company get( Integer id ) {
		
		// Retrieve existing person
		// Create a JPA query
		Company company = (Company)entityManager.createQuery("FROM Company as c WHERE c.id = :id").setParameter("id",id).getSingleResult();
		
		return company;
	}
	public void add(Company company) {
		// Persists to db
		entityManager.persist(company);
		
	}
	
	/**
	 * Deletes an existing person
	 * @param id the id of the existing person
	 */
	public void delete(Integer id) {
		
		Company company = this.get(id);		
		entityManager.remove(company);
		
	}
	
	/**
	 * Edits an existing person
	 */
	public void edit(Company company) {
		
		// Retrieve existing person via id
		Company existingCompany = this.get(company.getId());
		existingCompany.setCompanyName(company.getCompanyName());
		// Save updates
		entityManager.merge(existingCompany);
	}

}
