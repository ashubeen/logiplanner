package com.tan.logistics.planner.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tan.logistics.admin.model.Contract;
import com.tan.logistics.admin.model.Person;
import com.tan.logistics.admin.model.Vessel;
import com.tan.logistics.admin.request.ProjectRequest;
import com.tan.logistics.admin.request.VesselRequest;
import com.tan.logistics.admin.response.LogisticsResponse;
import com.tan.logistics.admin.response.Option;
import com.tan.logistics.admin.service.CompanyService;
import com.tan.logistics.admin.service.ContractService;
import com.tan.logistics.planner.model.Project;
import com.tan.logistics.planner.service.ProjectService;

@Controller
@RequestMapping("/scheduler/project")
public class ProjectController 
{

	
	
	@Resource(name="projectService")
    private ProjectService projectService;
	
	
	@Resource(name="contractService")
	private ContractService contractService;
 	
	@RequestMapping("/projects")
	public String all(Model model) {
	
	    return "project";
	}
	
	
	@RequestMapping(value="/listProjects", method= RequestMethod.POST )
	public @ResponseBody LogisticsResponse<Project>  getAllProjects()
	{
		List<Project> projects = projectService.getAll();		
		LogisticsResponse<Project> response = new LogisticsResponse<Project>();		
		response.setResult("OK");
		response.setRecords(projects);
		
		return response;
	}
	
	
    @RequestMapping(value="/getContractOptions", method= RequestMethod.POST )
  		public @ResponseBody LogisticsResponse<List<Option>>  getContractOptions()
  		{
  			List<Contract> contractList = contractService.getAll();
  			List<Option> contractOptions = new ArrayList<Option>();
  			LogisticsResponse<List<Option>> response = new LogisticsResponse<List<Option>>();
  	     	
  	     	for (Contract contract : contractList) 
  	     	{
  	     		Option option = new Option(contract.getId() != null ? contract.getId().toString(): "", contract.getContractName());
  	     		contractOptions.add(option);
  	  		}
  	     	response.setOptions(contractOptions);		  	     	
  	       	response.setResult("OK");	  					
  			return response;
  		}

    
    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public @ResponseBody LogisticsResponse<Project> postAdd(@RequestBody ProjectRequest request) {
    	

    	projectService.add(request.getRecord());    	
    	LogisticsResponse<Project> response = new LogisticsResponse<Project>();
    	response.setResult("OK");
    	response.setRecord(request.getRecord());
    	return response;
	}
	
}