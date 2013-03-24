package com.tan.logistics.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tan.logistics.admin.model.Person;
import com.tan.logistics.admin.request.PersonRequest;
import com.tan.logistics.admin.response.LogisticsResponse;
import com.tan.logistics.admin.service.PersonService;



@Controller
@RequestMapping("/admin/person")
public class PersonController {

	@Resource(name="personService")
    private PersonService personService;
 	
	@RequestMapping("/persons")
	public String all(Model model) {
	
	    return "person";
	}
	
	@RequestMapping(value="/listPersons", method= RequestMethod.POST )
	public @ResponseBody LogisticsResponse<Person>  getAllPersons()
	{
		List<Person> persons = personService.getAll();		
		LogisticsResponse<Person> response = new LogisticsResponse<Person>();		
		response.setResult("OK");
		response.setRecords(persons);
		
		return response;
	}
	
	  @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Person> postAdd(@RequestBody PersonRequest request) {
	
	    	personService.add(request.getRecord());	    	
	    	LogisticsResponse<Person> response = new LogisticsResponse<Person>();
	    	response.setResult("OK");
	    	response.setRecord(request.getRecord());	    	
	    	return response;
		}
	
	    @RequestMapping(value = "/updatePerson", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Person> updatePerson(@RequestBody PersonRequest request) {
	
	    	
	    	personService.edit(request.getRecord());
	    	LogisticsResponse<Person> response = new LogisticsResponse<Person>();
	    	response.setResult("OK");
	    	return response;
		}
	
	    
	    @RequestMapping(value = "/deletePerson", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Person> deletePerson(@RequestBody PersonRequest request) {
			   	
	    	personService.delete(request.getId());	    	
	    	LogisticsResponse<Person> response = new LogisticsResponse<Person>();
	    	response.setResult("OK");
	    	return response;
		}
		
    
 /*   @RequestMapping(value="/listpeople", method= RequestMethod.POST )
	public @ResponseBody LogisticsResponse<Person>  getAll()
	{
		
		List<Person> companies = personService.getAll();
		
		LogisticsResponse<Person> response = new LogisticsResponse<Person>();
		
		response.setResult("OK");
		response.setRecords(companies);
		
		return response;
	}
	
	  @RequestMapping(value = "/addcompany", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Person> postAdd(@RequestBody PersonRequest company) {
			
		  System.out.println("comp id ***" + company.getRecord().getId());
		  System.out.println("comp getid ***" + company.getId());
	    	personService.add(company.getRecord());	    	
	    	LogisticsResponse<Person> response = new LogisticsResponse<Person>();
	    	response.setResult("OK");
	    	response.setRecord(company.getRecord());
	    	
	    	return response;
		}

	    @RequestMapping(value = "/updatecompany", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Person> updatePerson(@RequestBody PersonRequest company) {

	    	
	    	personService.edit(company.getRecord());
	    	LogisticsResponse<Person> response = new LogisticsResponse<Person>();
	    	response.setResult("OK");
	    	return response;
		}

	    
	    @RequestMapping(value = "/deletecompany", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Person> deleteTitle(@RequestBody PersonRequest company) {
			   	
	    	personService.delete(company.getId());	    	
	    	LogisticsResponse<Person> t = new LogisticsResponse<Person>();
	    	t.setResult("OK");
	    	return t;
		}
	   

    @RequestMapping("/list")
    public String listPeople(Map<String, Object> map) {

        map.put("person", new Person());
        map.put("peopleList", personService.getAll());
        return "people";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model, Map<String, Object> map) {
    
    	// Create new Person and add to model
    	model.addAttribute("personAttribute", new Person());
    	List<Company> compList = compService.getAll();
     	Map<String,String> companiesDD = new LinkedHashMap<String,String>();
     	for (Company company : compList) 
     	{
     		companiesDD.put(company.getId() != null ? company.getId().toString() : "" , company.getCompanyName());
 		}
     
         map.put("companies", companiesDD);
    	// This will resolve to /WEB-INF/jsp/add-record.jsp
    	return "add-person";
	}
 
    /**
     * Adds a new record
     */
   /* @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("personAttribute") Person person) {

		// Delegate to service
    	personService.add(person);

		// Redirect to url
		return "redirect:/admin/people/list";
	}
   
    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public String deletePerson(@PathVariable("id") Integer personId) {

        personService.delete(personId);
        return "redirect:/admin/people/list";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam("id") Integer personId, Model model, Map<String, Object> map) {
    	
    	// Retrieve COmpany by id
     	Person existingPerson = personService.get(personId); 
    	// Add to model
    	model.addAttribute("personAttribute", existingPerson);
     	List<Company> compList = compService.getAll();
     	Map<String,String> companiesDD = new LinkedHashMap<String,String>();
     	for (Company company : compList) 
     	{
     		companiesDD.put(company.getId() != null ? company.getId().toString() : "" , company.getCompanyName());
 		}
     
         map.put("companies", companiesDD);
    	// This will resolve to /WEB-INF/jsp/edit-record.jsp
    	return "edit-person";
	}
 
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@RequestParam("id") Integer personId, 
    						    @ModelAttribute("personAttribute") Person person) {
		
		// Assign id
    	person.setId(personId);
		
		// Delegate to service
		personService.edit(person);

		// Redirect to url
		return "redirect:/admin/people/list";
	}
 */
}
