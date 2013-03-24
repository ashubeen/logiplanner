package com.tan.logistics.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tan.logistics.admin.model.Company;
import com.tan.logistics.admin.request.CompanyRequest;
import com.tan.logistics.admin.response.LogisticsResponse;
import com.tan.logistics.admin.response.Option;
import com.tan.logistics.admin.service.CompanyAddressService;
import com.tan.logistics.admin.service.CompanyService;

@Controller
@RequestMapping("/admin/company")
public class CompanyController 
{

	
	
	@Resource(name="companyService")
	private CompanyService compService;
	
	@Resource(name="companyAddressService")
	private CompanyAddressService companyAddressService;
	
	@RequestMapping("/companies")
	public String alltitles(Model model) {
	
	    return "company";
	}
	
	@RequestMapping(value="/listCompanies", method= RequestMethod.POST )
	public @ResponseBody LogisticsResponse<Company>  getAllCompanies()
	{
		System.out.println("listing companies in getAllCompanies *****");
		List<Company> companies = compService.getAll();
		
		LogisticsResponse<Company> response = new LogisticsResponse<Company>();
		
		response.setResult("OK");
		response.setRecords(companies);
		
		return response;
	}
	
	  @RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Company> postAdd(@RequestBody CompanyRequest request) {

	    	compService.add(request.getRecord());	    	
	    	LogisticsResponse<Company> response = new LogisticsResponse<Company>();
	    	response.setResult("OK");
	    	response.setRecord(request.getRecord());
	    	
	    	return response;
		}

	    @RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Company> updateCompany(@RequestBody CompanyRequest request) {

	    	
	    	compService.edit(request.getRecord());
	    	LogisticsResponse<Company> response = new LogisticsResponse<Company>();
	    	response.setResult("OK");
	    	return response;
		}

	    
	    @RequestMapping(value = "/deleteCompany", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Company> deleteCompany(@RequestBody CompanyRequest request) {
			   	
	    	compService.delete(request.getId());	    	
	    	LogisticsResponse<Company> response = new LogisticsResponse<Company>();
	    	response.setResult("OK");
	    	return response;
		}
	    
	    @RequestMapping(value="/getCompanyOptions", method= RequestMethod.POST )
		public @ResponseBody LogisticsResponse<List<Option>>  getCompanyOptions()
		{
			List<Company> compList = compService.getAll();
			List<Option> companyOptions = new ArrayList<Option>();
			LogisticsResponse<List<Option>> response = new LogisticsResponse<List<Option>>();
	     	//Map<String,String> companiesDD = new LinkedHashMap<String,String>();
	     	for (Company company : compList) 
	     	{
	     		Option option = new Option(company.getId() != null ? company.getId().toString(): "", company.getCompanyName());
	     		companyOptions.add(option);
	     		//companiesDD.put(company.getId() != null ? company.getId().toString() : "" , company.getCompanyName());
	 		}
	     	response.setOptions(companyOptions);	
	     	
	       	response.setResult("OK");
					
			return response;
		}
		
	   
	/*@RequestMapping(value="/companylist", method =RequestMethod.GET)
	public String getCompanyRecord(Model model)
	{
		
		List<Comp> companies = compService.getAll();
		
		List<CompanyDTO> companysDTO = new ArrayList<CompanyDTO>();
		
		for(Comp company : companies)
		{
			
			CompanyDTO dto= new CompanyDTO();
			
			dto.setAddresses(companyAddressService.getAll(company.getId()));
			dto.setCompanyName(company.getCompanyName());
		
			dto.setId(company.getId());
		
			companysDTO.add(dto);
			
		}
		
		model.addAttribute("companies", companysDTO);
		return "companylist";
	}
	
	
	
	*/
//	
//	   /**
//     *  Retrieves the "Add New Record" page
//     */
//    @RequestMapping(value = "/addcompany", method = RequestMethod.GET)
//    public String getAdd(Model model) {
//    
//    	// Create new Person and add to model
//    	model.addAttribute("companyAttribute", new Comp());
//
//    	// This will resolve to /WEB-INF/jsp/add-record.jsp
//    	return "addcompany";
//	}
// 
//    /**
//     * Adds a new record
//     */
//    @RequestMapping(value = "/addcompany", method = RequestMethod.POST)
//    public String postAdd(@ModelAttribute("companyAttribute") Comp company) {
//
//		// Delegate to service
//		compService.add(company);
//
//		// Redirect to url
//		return "redirect:/admin/company/companylist";
//	}
//    
//
//    
//    /**
//     * Deletes a record including all the associated credit cards
//     */
//    @RequestMapping(value = "/deletecompany", method = RequestMethod.GET)
//    public String getDelete(@RequestParam("id") Integer companyId) {
//    
//    	//First delete all the association address and then delete the company
//    	companyAddressService.deleteAll(companyId);
//    	//delete the company now
//		compService.delete(companyId);
//
//		// Redirect to url
//		return "redirect:/admin/company/companylist";
//	}
//    
//    @RequestMapping(value = "/editcompany", method = RequestMethod.GET)
//    public String getEdit(@RequestParam("id") Integer companyId, Model model) {
//    	
//    	// Retrieve COmpany by id
//     	Comp existingCompany = compService.get(companyId); 
//    	// Add to model
//    	model.addAttribute("companyAttribute", existingCompany);
//
//    	// This will resolve to /WEB-INF/jsp/edit-record.jsp
//    	return "editcompany";
//	}
// 
//    @RequestMapping(value = "/editcompany", method = RequestMethod.POST)
//    public String postEdit(@RequestParam("id") Integer companyId, 
//    						    @ModelAttribute("companyAttribute") Comp company) {
//		
//		// Assign id
//    	company.setId(companyId);
//		
//		// Delegate to service
//		compService.edit(company);
//
//		// Redirect to url
//		return "redirect:/admin/company/companylist";
//	}
// 
    
}
