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
import com.tan.logistics.admin.model.Title;
import com.tan.logistics.admin.request.TitleRequest;
import com.tan.logistics.admin.response.LogisticsResponse;
import com.tan.logistics.admin.response.Option;
import com.tan.logistics.admin.service.TitleService;


@Controller
@RequestMapping("/admin/title")
public class TitleController {

	@Resource(name="titleService")
    private TitleService titleService;

	
    @RequestMapping("/titles")
    public String alltitles(Model model) {
    	/* mapping to jsp*/
        return "title";
    }
    
    @RequestMapping(value="/listtitles", method= RequestMethod.POST )
    public @ResponseBody LogisticsResponse<Title>  listTitles()
    {
    	List<Title> titles = titleService.getAll();    	
    	LogisticsResponse<Title>  response = new LogisticsResponse<Title>();    	
    	response.setResult("OK");
    	response.setRecords(titles);    	
    	return response;
    }
  
    @RequestMapping(value = "/addtitle", method = RequestMethod.POST)
    public @ResponseBody LogisticsResponse<Title> postAdd(@RequestBody TitleRequest request) {
		
    	titleService.add(request.getRecord());    	
    	LogisticsResponse<Title> response = new LogisticsResponse<Title>();
    	response.setResult("OK");
    	response.setRecord(request.getRecord());
    	return response;
	}
    
    @RequestMapping(value = "/updateTitle", method = RequestMethod.POST)
    public @ResponseBody LogisticsResponse<Title> updateTitle(@RequestBody TitleRequest request) {

    	titleService.edit(request.getRecord());
    	LogisticsResponse<Title> response = new LogisticsResponse<Title>();
    	response.setResult("OK");
    	return response; 
	}

    
    @RequestMapping(value = "/deleteTitle", method = RequestMethod.POST)
    public @ResponseBody LogisticsResponse<Title> deleteTitle(@RequestBody TitleRequest request) {
		   	
    	
    	titleService.delete(request.getId());    	
    	LogisticsResponse<Title> response = new LogisticsResponse<Title>();
    	response.setResult("OK");
    	return response;  	

	}
    
    @RequestMapping(value="/getTitleOptions", method= RequestMethod.POST )
	public @ResponseBody LogisticsResponse<List<Option>>  getCompanyOptions()
	{
		List<Title> titleList = titleService.getAll();
		List<Option> titleOptions = new ArrayList<Option>();
		LogisticsResponse<List<Option>> response = new LogisticsResponse<List<Option>>();
     	
     	for (Title title : titleList) 
     	{
     		Option option = new Option(title.getId() != null ? title.getId().toString(): "", title.getTitleName());
     		titleOptions.add(option);
     		
 		}
     	response.setOptions(titleOptions);	
     	
       	response.setResult("OK");
				
		return response;
	} 
    /*
     * 
    @RequestMapping("/titlelist")
    public String listTitles(Model model) {
    
    	model.addAttribute("titles", titleService.getAll());
    	//jsp mapping
    	System.out.println("listing titles");
        return "title";
    }

   
    @RequestMapping(value = "/addtitle", method = RequestMethod.GET)
    public String getAdd(Model model) {

    	model.addAttribute("titleAttribute", new Title());

    	// This will resolve to add-title jsp
    	return "add-title";
	}

    
 /*   *//**
     * Retrieves the "Edit Existing Record" page
     *//*
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam("id") Integer titleId, Model model) {

    	Title existingTitle = titleService.get(titleId);
    	
    	model.addAttribute("titleAttribute", existingTitle);

    	return "edit-title";
	}
    

    *//**
     * Edits an existing record
     *//*
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@RequestParam("id") Integer titleId, 
    						    @ModelAttribute("titleAttribute") Title title) {
		
    	System.out.println("title " + titleId);
    	title.setTitleId(titleId);
    	
    	titleService.editTitle(title);

		return "redirect:/admin/title/titlelist";
	}*/
    
}
