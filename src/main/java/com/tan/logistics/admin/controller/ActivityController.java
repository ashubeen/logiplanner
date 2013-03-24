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
import org.springframework.web.bind.annotation.ResponseBody;

import com.tan.logistics.admin.model.Activity;
import com.tan.logistics.admin.request.ActivityRequest;
import com.tan.logistics.admin.response.LogisticsResponse;
import com.tan.logistics.admin.response.Option;
import com.tan.logistics.admin.service.ActivityService;

@Controller
@RequestMapping("/admin/activity")
public class ActivityController 
{

	
	@Resource(name="activityService")
	private ActivityService activityService;
	

	@RequestMapping("/activities")
	public String alltitles(Model model) {
	
	    return "activity";
	}
	
	@RequestMapping(value="/listactivities", method= RequestMethod.POST )
	public @ResponseBody LogisticsResponse<Activity>  getAllCompanies()
	{
		List<Activity> activities = activityService.getAll();		
		LogisticsResponse<Activity> response = new LogisticsResponse<Activity>();		
		response.setResult("OK");
		response.setRecords(activities);
		
		return response;
	}
	
	  @RequestMapping(value = "/addactivity", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Activity> postAdd(@RequestBody ActivityRequest request) {
			
		   	activityService.add(request.getRecord());	    	
	    	LogisticsResponse<Activity> response = new LogisticsResponse<Activity>();
	    	response.setResult("OK");
	    	response.setRecord(request.getRecord());
	    	
	    	return response;
		}

	    @RequestMapping(value = "/updateactivity", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Activity> updateActivity(@RequestBody ActivityRequest request) {

	    	
	    	activityService.edit(request.getRecord());
	    	LogisticsResponse<Activity> response = new LogisticsResponse<Activity>();
	    	response.setResult("OK");
	    	return response;
		}

	    
	    @RequestMapping(value = "/deleteactivity", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Activity> deleteTitle(@RequestBody ActivityRequest request) {
			   	
	    	activityService.delete(request.getId());	    	
	    	LogisticsResponse<Activity> t = new LogisticsResponse<Activity>();
	    	t.setResult("OK");
	    	return t;
		}
	    
	    @RequestMapping(value="/getParentActivityOptions", method= RequestMethod.POST )
		public @ResponseBody LogisticsResponse<List<Option>>  getActivityOptions()
		{
			List<Activity> activityList = activityService.getParentActivities();
			List<Option> activityOptions = new ArrayList<Option>();
			LogisticsResponse<List<Option>> response = new LogisticsResponse<List<Option>>();

	     	for (Activity activity : activityList) 
	     	{
	     		Option option = new Option(activity.getId() != null ? activity.getId().toString(): "", activity.getActivity());
	     		activityOptions.add(option);
	     	}
	     	response.setOptions(activityOptions);	
	     	
	       	response.setResult("OK");
					
			return response;
		}
	/*
	@RequestMapping(value="/activitylist", method =RequestMethod.GET)
	public String getActivityRecord(Model model)
	{
		
		List<Activity> activities = activityService.getAll()();
		
		List<ActivityDTO> activityDTO = new ArrayList<ActivityDTO>();
		
		for(Activity activity : activities)
		{
			ActivityDTO dto= new ActivityDTO();
			Activity parentActivity = null;
			dto.setActivity(activity.getActivity());
			dto.setId(activity.getId());
			dto.setLevel(activity.getLevel());
			if(activity.getParentId() != null)
			{
				parentActivity = activityService.get(activity.getParentId());
				dto.setParentActivityName(parentActivity.getActivity());
			}
			activityDTO.add(dto);
			/*if(dto.getParentId()==null)
			{
				//this is not a good code need to work on same entity mapping later , for now keep as is
				dto.setActivities(activityService.getSubActivities(null, dto.getParentId()));
				activityDTO.add(dto);
			}*/
	//	}
		
		/*model.addAttribute("activities", activityDTO);
		return "activitylist";
	}
	
	
	
	
	   /**
  *  Retrieves the "Add New Record" page
  */
/* @RequestMapping(value = "/add", method = RequestMethod.GET)
 public String getAdd(Map<String, Object> map) {
 
	Activity act = new Activity();
	act.setLevel(1);
 	map.put("activityAttribute", act);
 	List<Activity> activitiesList = activityService.getParentActivities();
 	Map<String,String> parentDD = new LinkedHashMap<String,String>();
 	parentDD.put("", null);
 	for (Activity activity : activitiesList) 
 	{
 		parentDD.put(activity.getId() != null ? activity.getId().toString() : "" , activity.getActivity());
	}
 	
 	 Map<String,String> levelsDD = new LinkedHashMap<String,String>();
 	 levelsDD.put("1", "Level 1");
 	 levelsDD.put("2", "Level 2");
 	  	
 	 map.put("levels", levelsDD);
 	    
     map.put("parentActivities", parentDD);
 	// This will resolve to /WEB-INF/jsp/add-record.jsp
 	return "addactivity";
	}

 /**
  * Adds a new record
  */
 @RequestMapping(value = "/add", method = RequestMethod.POST)
 public String postAdd(@ModelAttribute("activityAttribute") Activity activity) {

	 	// Delegate to service
		activityService.add(activity);

		// Redirect to url
		return "redirect:/admin/activity/activitylist";
	}
 
  
 /**
  * Deletes a record including all the associated credit cards
  */
 
/* @RequestMapping(value = "/deleteactivity", method = RequestMethod.GET)
/* public String getDelete(@RequestParam("id") Integer activityId) {
 
 	//First delete all the child activities
	 activityService.deleteChildActivities(activityId);
	 
 	//delete the activity now
	 activityService.deleteActivity(activityId);
		// Redirect to url
		return "redirect:/admin/activity/activitylist";
	}
 */
 /** @RequestMapping(value = "/editactivity", method = RequestMethod.GET)
 public String getEdit(@RequestParam("id") Integer activityId, Map<String, Object> map ) {
 	
 	// Retrieve Existing Activity by id
  	Activity existingActivity = activityService.get(activityId); 
 	// Add to model
 //	model.addAttribute("activityAttribute", existingActivity);
 	
 	map.put("activityAttribute", existingActivity);
 	List<Activity> activitiesList = activityService.getParentActivities();
 	Map<String,String> parentDD = new LinkedHashMap<String,String>();
 	parentDD.put("", null);
 	for (Activity activity : activitiesList) 
 	{
 		parentDD.put(activity.getId() != null ? activity.getId().toString() : "" , activity.getActivity());
		}
 
     map.put("parentActivities", parentDD);
     
    Map<String,String> levelsDD = new LinkedHashMap<String,String>();
    levelsDD.put("1", "Level 1");
    levelsDD.put("2", "Level 2");
  	
    map.put("levels", levelsDD);
    map.put("parentActivities", parentDD);


 	// This will resolve to /WEB-INF/jsp/edit-record.jsp
 	return "editactivity";
	}

 @RequestMapping(value = "/editactivity", method = RequestMethod.POST)
 public String postEdit(@RequestParam("id") Integer activityId, 
 						    @ModelAttribute("activityAttribute") Activity activity) {
		
		// Assign id
 		activity.setId(activityId);
		
		// Delegate to service
		activityService.editActivity(activity);

		// Redirect to url
		return "redirect:/admin/activity/activitylist";
	}

**/

}
