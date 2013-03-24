package com.tan.logistics.admin.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tan.logistics.admin.model.Contract;



@Service("contractService")
@Transactional
public class ContractService{

	
	private EntityManager entityManager;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this. entityManager = entityManager;
    }

	public void add(Contract contract) {
		entityManager.persist(contract);
		
	}
	public List<Contract> getAll() {
	CriteriaQuery<Contract> c = entityManager.getCriteriaBuilder().createQuery(Contract.class);
	Root<Contract> from = c.from(Contract.class);
	c.orderBy(entityManager.getCriteriaBuilder().asc(from.get("contractName")));
	return entityManager.createQuery(c).getResultList();
	}


  public void delete(Integer id) {
      Contract contract = entityManager.find(Contract.class, id);
      if (null != contract) {
    	  entityManager.remove(contract);
      }
  }
	
	 public void edit(Contract contract) {
	
	    	Contract existingContract = this.get(contract.getId());
			
		 	existingContract.setContractName(contract.getContractName());
		 	existingContract.setComments(contract.getComments());
		 	existingContract.setVesselId(contract.getVesselId());
		 	existingContract.setStartDate(contract.getStartDate());
		 	existingContract.setEndDate(contract.getEndDate());
		 	existingContract.setCountry(contract.getCountry());
		 	//TODO: Add rest of the colums
		 	entityManager.merge(existingContract);
	}
	
	
	public Contract get(Integer id){		
	
		Contract contract = (Contract) entityManager.createQuery("from Contract v where v.id = :id")
			.setParameter("id", id).getSingleResult();
	
		return contract;
	}


}
