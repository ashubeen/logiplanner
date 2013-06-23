package com.tan.logistics.admin.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tan.logistics.admin.model.Location;
import com.tan.logistics.admin.request.LocationRequest;
import com.tan.logistics.admin.response.LogisticsResponse;
import com.tan.logistics.admin.service.LocationCoordinatesService;
import com.tan.logistics.admin.service.LocationService;

@Controller
@RequestMapping("/admin/location")
public class LocationController {

	protected static Logger logger = Logger.getLogger("controller");
	
	
	@Resource(name="locationService")
	private LocationService locationService;
	
	@Resource(name="locCoordinatesService")
	private LocationCoordinatesService locCoordinatesService;
	
		
	@RequestMapping("/admin/location")
	public String alltitles(Model model) {
	
	    return "location";
	}
	
	@RequestMapping(value="/locations", method= RequestMethod.POST )
	public @ResponseBody LogisticsResponse<Location>  getAllLocations()
	{
		List<Location> locations = locationService.getAll();		
		LogisticsResponse<Location> response = new LogisticsResponse<Location>();		
		response.setResult("OK");
		response.setRecords(locations);
		
		return response;
	}
	
	  @RequestMapping(value = "/addLocation", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Location> postAdd(@RequestBody LocationRequest request) {

	    	locationService.add(request.getRecord());	    	
	    	LogisticsResponse<Location> response = new LogisticsResponse<Location>();
	    	response.setResult("OK");
	    	response.setRecord(request.getRecord());	    	
	    	return response;
		}

	    @RequestMapping(value = "/updateLocation", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Location> updateLocation(@RequestBody LocationRequest request) {

	    	
	    	locationService.edit(request.getRecord());
	    	LogisticsResponse<Location> response = new LogisticsResponse<Location>();
	    	response.setResult("OK");
	    	return response;
		}

	    
	    @RequestMapping(value = "/deleteLocation", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Location> deleteLocation(@RequestBody LocationRequest request) {
			   	
	    	locationService.delete(request.getId());	    	
	    	LogisticsResponse<Location> response = new LogisticsResponse<Location>();
	    	response.setResult("OK");
	    	return response;
		}
		
	/**
	 * Retrieves the "Records" page
	 */
   /* @RequestMapping(value = "/locationlist", method = RequestMethod.GET)
    public String getRecords(Model model) {

    	List<Location> locations = locationService.getAll();
       
    	List<LocationDTO> locationDTOs = new ArrayList<LocationDTO>();
    	
    	for (Location location: locations) {
    		
    		LocationDTO dto = new LocationDTO();    		
			dto.setLocationId(location.getId());
			dto.setLocType(location.getLocType());
			dto.setLocName(location.getLocName());
			dto.setLocCountry(location.getLocCountry());
			dto.setLocCoordintes(locCooridinatesService.getAll(location.getId()));
			
			locationDTOs.add(dto);
    	}
    	
    	model.addAttribute("locations", locationDTOs);
    
		return "locationRecords";
	}
    
    /**
     *  Retrieves the "Add New Record" page
     */
  /*  @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model) {

    	model.addAttribute("locationAttribute", new Location());

    	// This will resolve to add-location jsp
    	return "add-location";
	}

    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("locationAttribute") Location location) {
		
		locationService.add(location);

		// Redirect to url
		return "redirect:/admin/location/locationlist";
	}
    

    /**
     * Deletes a record including all the associated credit cards
     */
  /*  @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String getDelete(@RequestParam("id") Integer locationId) {
    	
    	locCooridinatesService.deleteAll(locationId);
        System.out.println("delte all done");
		locationService.delete(locationId);

		return "redirect:/admin/location/locationlist";
	}
    
    /**
     * Retrieves the "Edit Existing Record" page
     */
  /*  @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam("id") Integer locationId, Model model) {

    	Location existingLocation = locationService.get(locationId);

    	model.addAttribute("locationAttribute", existingLocation);

    	return "edit-location";
	}
    

    /**
     * Edits an existing record
     */
 /*   @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@RequestParam("id") Integer locationId, 
    						    @ModelAttribute("locationAttribute") Location location) {
			
		location.setId(locationId);
	
		locationService.edit(location);

		return "redirect:/admin/location/locationlist";
	}*/
    
}