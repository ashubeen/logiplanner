package com.tan.logistics.planner.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.tan.logistics.planner.model.Project;

@Service("projectService")
@Transactional
public class ProjectService 
{

	
	private EntityManager em;
	
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
        
  
    public void add(Project project) {
        em.persist(project);
    }


    public List<Project> getAll() {
        CriteriaQuery<Project> s = em.getCriteriaBuilder().createQuery(Project.class);
        Root<Project> from =s.from(Project.class);
        s.orderBy(em.getCriteriaBuilder().asc(from.get("projectName")));
        return em.createQuery(s).getResultList();
    }

    public void delete(Integer id) {
        Project project = em.find(Project.class, id);
        if (null != project) {
            em.remove(project);
        }
    }
    
	/**
	 * Edits an existing Project
	 */
	public void edit(Project project) {

		// Retrieve existing Project via id
		Project existingProject = this.get(project.getId());
		existingProject.setContractId(project.getContractId());
		existingProject.setEndDate(project.getEndDate());
		existingProject.setId(project.getId());
		existingProject.setProjectName(project.getProjectName());
		existingProject.setStartDate(project.getStartDate());
		existingProject.setStatus(project.getStatus());
		
		// Save updates
		em.merge(existingProject);
	}

	  public Project get(Integer id)
	    {
	    	
		  Project project = (Project) em.createQuery("from Project s where s.id =:id").setParameter("id", id).getSingleResult();
	    	return project;
	    }
}
