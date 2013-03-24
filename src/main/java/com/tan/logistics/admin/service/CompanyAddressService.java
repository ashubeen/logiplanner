package com.tan.logistics.admin.service;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tan.logistics.admin.model.Company;
import com.tan.logistics.admin.model.CompanyAddress;

@Service("companyAddressService")
@Transactional
public class CompanyAddressService {

	private EntityManager entityManager;
	
	@Resource(name="companyService")
	private CompanyService companyService;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this. entityManager = entityManager;
    }
    
    /**
     * 
     * @param companyId
     * @return
     */
    public List<CompanyAddress> getAll(Integer companyId)
    {
    	Query query = entityManager.createQuery("FROM CompanyAddress where company.id="+companyId);
    	
    	return query.getResultList();
    	
    }

    public List<CompanyAddress> getAll()
    {
    	Query query = entityManager.createQuery("FROM CompanyAddress");
    	
    	return query.getResultList();
    	
    }
    
    
    public CompanyAddress get(Integer id)
    {
    	
    	CompanyAddress companyAddress = (CompanyAddress)entityManager.createQuery("FROM CompanyAddress ca WHERE ca.id=:id").setParameter("id", id).getSingleResult();
    	return companyAddress;
    }
    
    /**
     * 
     * @param companyId
     * @param companyAddress
     */
    public void add(Integer companyId, CompanyAddress companyAddress)
    {
    	
    	Company company = companyService.get(companyId);
    	
    	companyAddress.setCompany(company);
    	entityManager.persist(companyAddress);
    }
    
    public void delete(Integer id)
    {
    	
    	CompanyAddress companyAddress = this.get(id);
    	
    	entityManager.remove(companyAddress);
    }
    
    
    public void deleteAll(Integer companyId)
    {
    	Query query = entityManager.createQuery("DELETE FROM CompanyAddress WHERE company.id="+companyId);
    	query.executeUpdate();
    	
    }
    
    public void edit(CompanyAddress address)
    {
    	CompanyAddress existingCompanyAddress= this.get(address.getId());
    	
    	existingCompanyAddress.setAddress(address.getAddress());
    	existingCompanyAddress.setAddressType(address.getAddressType());
    	existingCompanyAddress.setCity(address.getCity());
    	existingCompanyAddress.setCountry(address.getCountry());
    	existingCompanyAddress.setState(address.getState());
    	existingCompanyAddress.setZipCode(address.getZipCode());
    	
    	entityManager.merge(existingCompanyAddress);
    	
    	
    	
    	
    }
    
}
