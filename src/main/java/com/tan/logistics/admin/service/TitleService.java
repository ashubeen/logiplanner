package com.tan.logistics.admin.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tan.logistics.admin.model.Title;
import com.tan.logistics.admin.model.Title;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.List;

@Service("titleService")
@Transactional
public class TitleService {

	private EntityManager em;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
            
    public void add(Title title) {
        em.persist(title);
    }

    
    public List<Title> getAll() {
        CriteriaQuery<Title> c = em.getCriteriaBuilder().createQuery(Title.class);
        Root<Title> from = c.from(Title.class);
        c.orderBy(em.getCriteriaBuilder().asc(from.get("titleName")));
        return em.createQuery(c).getResultList();
    }

   
    public void delete(Integer id) {
        Title title = em.find(Title.class, id);
        if (null != title) {
            em.remove(title);
        }
    }
    
    public void edit(Title title) {

    	Title existingTitle = this.get(title.getId());
		
	 	existingTitle.setTitleName(title.getTitleName());
	 	existingTitle.setHighestQualification(title.getHighestQualification());
	 
	 	em.merge(existingTitle);
	}
	
	
	public Title get(Integer id){		

		Title title = (Title) em.createQuery("from Title v where v.id = :id")
    		.setParameter("id", id).getSingleResult();

		return title;
	}

    
}
