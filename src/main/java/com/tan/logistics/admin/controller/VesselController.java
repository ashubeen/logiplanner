package com.tan.logistics.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tan.logistics.admin.model.Vessel;
import com.tan.logistics.admin.request.VesselRequest;
import com.tan.logistics.admin.response.LogisticsResponse;
import com.tan.logistics.admin.response.Option;
import com.tan.logistics.admin.service.CompanyService;
import com.tan.logistics.admin.service.VesselService;

@Controller
@RequestMapping("/admin/vessel")
public class VesselController {

	@Resource(name="vesselService")
    private VesselService vesselService;

	@Resource(name="companyService")
	private CompanyService compService;
	
	
	 @RequestMapping("/vessels")
	    public String all(Model model) {
	    	/* mapping to jsp*/
	        return "vessel";
	    }
	    
	    @RequestMapping(value="/listVessels", method= RequestMethod.POST )
	    public @ResponseBody LogisticsResponse<Vessel>  listVessels()
	    {
	    	List<Vessel> vessels = vesselService.getAll();    	
	    	LogisticsResponse<Vessel>  response = new LogisticsResponse<Vessel>();    	
	    	response.setResult("OK");
	    	response.setRecords(vessels);   
	    	return response;
	    }
	  
	    @RequestMapping(value = "/addVessel", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Vessel> postAdd(@RequestBody VesselRequest request) {
	    	
	    	vesselService.add(request.getRecord());    	
	    	LogisticsResponse<Vessel> response = new LogisticsResponse<Vessel>();
	    	response.setResult("OK");
	    	response.setRecord(request.getRecord());
	    	return response;
		}
	    
	    @RequestMapping(value = "/updateVessel", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Vessel> updateVessel(@RequestBody VesselRequest request) {

	    	vesselService.edit(request.getRecord());
	    	LogisticsResponse<Vessel> response = new LogisticsResponse<Vessel>();
	    	response.setResult("OK");
	    	return response; 
		}

	    
	    @RequestMapping(value = "/deleteVessel", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Vessel> deleteVessel(@RequestBody VesselRequest request) {
			   	
	    	
	    	vesselService.delete(request.getId());    	
	    	LogisticsResponse<Vessel> response = new LogisticsResponse<Vessel>();
	    	response.setResult("OK");
	    	return response;  	

		}
	    
	    @RequestMapping(value="/getVesselOptions", method= RequestMethod.POST )
	  		public @ResponseBody LogisticsResponse<List<Option>>  getVesselOptions()
	  		{
	  			List<Vessel> vesselList = vesselService.getAll();
	  			List<Option> vesselOptions = new ArrayList<Option>();
	  			LogisticsResponse<List<Option>> response = new LogisticsResponse<List<Option>>();
	  	     	
	  	     	for (Vessel vessel : vesselList) 
	  	     	{
	  	     		Option option = new Option(vessel.getId() != null ? vessel.getId().toString(): "", vessel.getVesselName());
	  	     		vesselOptions.add(option);
	  	  		}
	  	     	response.setOptions(vesselOptions);		  	     	
	  	       	response.setResult("OK");	  					
	  			return response;
	  		}
	
   /* @RequestMapping("/vessellist")
    public String listVessel(Map<String, Object> map) {

        map.put("vessel", new Vessel());
        map.put("vesselList", vesselService.getAll());
       
        return "vessel";
    }

  /*  @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addLocation(@ModelAttribute("vessel") Vessel vessel, BindingResult result) {

        vesselService.addVessel(vessel);

        return "redirect:/admin/vessel/vessellist";
    }

    @RequestMapping("/delete/{vesselId}")
    public String removeVessel(@PathVariable("vesselId") Integer vesselId) {

        vesselService.removeVessel(vesselId);

        return "redirect:/admin/vessel/vessellist";
    }*/
    
    /**
     *  Retrieves the "Add New Record" page
     */
    /*@RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model, Map<String, Object> map) {

    	model.addAttribute("vesselAttribute", new Vessel());
    	List<Company> compList = compService.getAll();
     	Map<String,String> companiesDD = new LinkedHashMap<String,String>();
     	for (Company company : compList) 
     	{
     		companiesDD.put(company.getId() != null ? company.getId().toString() : "" , company.getCompanyName());
 		}
     
         map.put("companies", companiesDD);
    	// This will resolve to add-vessel jsp
    	return "add-vessel";
	}

    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("veselAttribute") Vessel vessel) {
		
    	vesselService.add(vessel);

		// Redirect to url
		return "redirect:/admin/vessel/vessellist";
	}
    

   
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String getDelete(@RequestParam("id") Integer vesselId) {
    	
    	   
    	vesselService.delete(vesselId);

		return "redirect:/admin/vessel/vessellist";
	}
    
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String postDelete(@RequestParam("id") Integer vesselId) {
    	
    	   
    	vesselService.delete(vesselId);

		return "redirect:/admin/vessel/vessellist";
	}
    
    
    /**
     * Retrieves the "Edit Existing Record" page
     */
   /* @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam("id") Integer vesselId, Map<String, Object> map) {

    	Vessel existingVessel = vesselService.get(vesselId);
    	List<Company> compList = compService.getAll();
     	Map<String,String> companiesDD = new LinkedHashMap<String,String>();
     	for (Company company : compList) 
     	{
     		companiesDD.put(company.getId() != null ? company.getId().toString() : "" , company.getCompanyName());
 		}
     
         map.put("companies", companiesDD);
         
         map.put("vesselAttribute", existingVessel);

    	return "edit-vessel";
	}
    

    /**
     * Edits an existing record
     */
   /* @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@RequestParam("id") Integer vesselId, 
    						    @ModelAttribute("vesselAttribute") Vessel vessel) {
	
    	// Assign id
    	vessel.setId(vesselId);
		
    	vesselService.edit(vessel);

		return "redirect:/admin/vessel/vessellist";
	}
    
    */
    

}
