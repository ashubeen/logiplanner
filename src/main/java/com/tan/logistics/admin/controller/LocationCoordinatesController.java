package com.tan.logistics.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tan.logistics.admin.model.LocationCoordinates;
import com.tan.logistics.admin.request.LocationCoordinatesRequest;
import com.tan.logistics.admin.request.LocationRequest;
import com.tan.logistics.admin.response.LogisticsResponse;
import com.tan.logistics.admin.service.LocationCoordinatesService;

@Controller
@RequestMapping("/admin/locationCoordinates")
public class LocationCoordinatesController {

	@Resource(name="locCoordinatesService")
    private LocationCoordinatesService locCoordinatesService;
	
	

	
	@RequestMapping(value = "/listCoordinates", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<LocationCoordinates> listAddress(@RequestBody LocationRequest request) {

		
		LogisticsResponse<LocationCoordinates> response = new LogisticsResponse<LocationCoordinates>();
		response.setRecords(locCoordinatesService.getAll(request.getId()));
		response.setResult("OK");
		return response;
	}

	/**
	 * Adds a new credit card
	 */
	
	@RequestMapping(value = "/addCoordinates", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<LocationCoordinates> postAdd(@RequestBody LocationCoordinatesRequest request) {
	
	
		locCoordinatesService.add(request.getId(), request.getRecord());
		LogisticsResponse<LocationCoordinates> response = new LogisticsResponse<LocationCoordinates>();
		response.setResult("OK");
		response.setRecord(request.getRecord());	
    	return response;
	
	}
	
	@RequestMapping(value = "/updateCoordinates", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<LocationCoordinates> update(@RequestBody LocationCoordinatesRequest request) {

		locCoordinatesService.edit(request.getRecord());
		LogisticsResponse<LocationCoordinates> response = new LogisticsResponse<LocationCoordinates>();
		response.setResult("OK");
		return response;
	}

	@RequestMapping(value = "/deleteCoordinates", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<LocationCoordinates> delete(@RequestBody LocationCoordinatesRequest request) {

		locCoordinatesService.delete(request.getId());
		LogisticsResponse<LocationCoordinates> t = new LogisticsResponse<LocationCoordinates>();
		t.setResult("OK");
		return t;
	}


   /* @RequestMapping("/locCoordinatesList")
    public String listLocationCoordinates(Map<String, Object> map) {

        map.put("locationCoordinates", new LocationCoordinates());
        map.put("locationCoordinatesList", locCoordinatesService.listLocationCoordinates());
        return "locationRecords";
    }*/
    
    /**
     * Retrieves the "Add New Credit Card" page
     */
  /*  @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(@RequestParam("id") Integer locationId, Model model) {
    	//logger.debug("Received request to show add page");
    
    	// Prepare model object
    	LocationCoordinates locCordinates = new LocationCoordinates();
    	locCordinates.setLocation(locationService.get(locationId));
    	
    	// Add to model
    	model.addAttribute("locCoordinationAttribute", locCordinates);

    	// This will resolve to /WEB-INF/jsp/add-credit-card.jsp
    	return "add-locCoordinates";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@RequestParam("locId") Integer locationId, 
    						    @ModelAttribute("locCoordinationAttribute") LocationCoordinates locationCoordinates) {    	

    	locCoordinatesService.add(locationId, locationCoordinates);

        return "redirect:/admin/location/locationlist";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String removeLocationCoordiantes(@RequestParam("id") Integer locCordinatesId) {

    	locCoordinatesService.delete(locCordinatesId);

        return "redirect:/admin/location/locationlist";
    }

      
    /**
     * Retrieves the "Edit Existing Record" page
     */
  /*  @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam("id") Integer locCordinatesId, Model model) {
  
    	LocationCoordinates existingLocCoordinates = locCoordinatesService.get(locCordinatesId);

    	model.addAttribute("locCoordinationAttribute", existingLocCoordinates);

    	return "edit-locCoordinates";
	}
    

    /**
     * Edits an existing record
     */
  /*  @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@RequestParam("id") Integer locCordinatesId, 
    						    @ModelAttribute("locCoordinationAttribute") LocationCoordinates locCooridinates) {
	
    	locCooridinates.setId(locCordinatesId);
    	System.out.println("Loc do id" + locCordinatesId);
    	locCoordinatesService.edit(locCooridinates);

		return "redirect:/admin/location/locationlist";
	}*/
}
