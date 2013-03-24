package com.tan.logistics.admin.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tan.logistics.admin.model.Contract;
import com.tan.logistics.admin.request.ContractRequest;
import com.tan.logistics.admin.response.LogisticsResponse;
import com.tan.logistics.admin.service.ContractService;

@Controller
@RequestMapping("/admin/contract")
public class ContractController {


	@Resource(name="contractService")
    private ContractService contractService;

	
	private static final DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");   

	 @RequestMapping("/contracts")
	    public String all(Model model) {
	    	/* mapping to jsp*/
	        return "contract";
	    }
	    
	    @RequestMapping(value="/listContracts", method= RequestMethod.POST )
	    public @ResponseBody LogisticsResponse<Contract>  listContracts()
	    {
	    	List<Contract> titles = contractService.getAll();    	
	    	LogisticsResponse<Contract>  response = new LogisticsResponse<Contract>();    	
	    	response.setResult("OK");
	    	response.setRecords(titles);   
	    	System.out.println("listing");
	    	return response;
	    }
	  
	    @RequestMapping(value = "/addContract", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Contract> postAdd(@RequestBody ContractRequest request) {
	    	
	    	contractService.add(request.getRecord());    	
	    	LogisticsResponse<Contract> response = new LogisticsResponse<Contract>();
	    	response.setResult("OK");
	    	response.setRecord(request.getRecord());
	    	return response;
		}
	    
	    @RequestMapping(value = "/updateContract", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Contract> updateContract(@RequestBody ContractRequest request) {

	    	contractService.edit(request.getRecord());
	    	LogisticsResponse<Contract> response = new LogisticsResponse<Contract>();
	    	response.setResult("OK");
	    	return response; 
		}

	    
	    @RequestMapping(value = "/deleteContract", method = RequestMethod.POST)
	    public @ResponseBody LogisticsResponse<Contract> deleteContract(@RequestBody ContractRequest request) {
			   	
	    	
	    	contractService.delete(request.getId());    	
	    	LogisticsResponse<Contract> response = new LogisticsResponse<Contract>();
	    	response.setResult("OK");
	    	return response;  	

		}
	
    /*@RequestMapping("/contractlist")
    public String listContract(Model model) {

    	model.addAttribute("contract", new Contract());
    	model.addAttribute("contracts", contractService.getAll());
        List<Contract> contractList = contractService.getAll();
        
    	model.addAttribute("contracts", contractList);
        return "contractlist";
    }
    
   /* 
    @RequestMapping("/contract")
    public String listContract(Map<String, Object> map) {

        map.put("contract", new Contract());
        map.put("contractList", contractService.listContracts());
        List<Contract> vslList = contractService.listContracts();
    	Map<String,String> contractsDD = new LinkedHashMap<String,String>();
    	for (Contract contract : vslList) 
    	{
    		contractsDD.put(contract.getContractId() != null ? contract.getContractId().toString() : "" , contract.getContractName());
		}
    	
    	   	

        map.put("contracts", contractsDD);
        return "contract";
    }

    @RequestMapping(value = "/contract/add", method = RequestMethod.POST)
    public String addLocation(@ModelAttribute("contract") Contract contract, BindingResult result) {

        contractService.addContract(contract);

        return "redirect:/contract";
    }

    @RequestMapping("/contract/delete/{contractId}")
    public String removeContract(@PathVariable("contractId") Integer contractId) {

        contractService.removeContract(contractId);

        return "redirect:/contract";
    }*/
    
    /**
     *  Retrieves the "Add New Record" page
     */
  /*  @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(Model model, Map<String, Object> map) {

    	model.addAttribute("contractAttribute", new ContractDTO());
    	List<Contract> contractsList = contractService.getAll();
    	Map<String,String> contractsDD = new LinkedHashMap<String,String>();
     	for (Contract contract : contractsList) 
     	{
     		contractsDD.put(contract.getId() != null ? contract.getId().toString() : "" , contract.getContractName());
 		}
     
         map.put("contracts", contractsDD);
    	
    	return "add-contract";
	}

    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("contractAttribute") ContractDTO contract) {
		
    	Contract contractModel = new Contract();
    	contractModel.setId(contract.getContractId());
    	contractModel.setContractName(contract.getContractName());
    	contractModel.setCountry(contract.getCountry());

		try {
			if (contract.getStartDate() != null)
				contractModel.setStartDate(new java.sql.Date((formater
						.parse(contract.getStartDate())).getTime()));

			if (contract.getStartDate() != null)
				contractModel.setEndDate(new java.sql.Date((formater
						.parse(contract.getEndDate())).getTime()));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    	contractModel.setContractId(contract.getContractId());
    	contractService.add(contractModel);

		// Redirect to url
		return "redirect:/admin/contract/contractlist";
	}
    

    /**
     * Deletes a record including all the associated credit cards
     */
   /* @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String getDelete(@RequestParam("id") Integer contractId) {
    	
    	  
    	contractService.delete(contractId);

    	return "redirect:/admin/contract/contractlist";
	}
    
    /**
     * Retrieves the "Edit Existing Record" page
     */
 /*   @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String getEdit(@RequestParam("id") Integer contractId, Model model, Map<String, Object> map) {
    	
    	Contract existingContract = contractService.get(contractId);
    	ContractDTO contractDTO = new ContractDTO();
    	contractDTO.setContractId(existingContract.getId());
    	contractDTO.setContractName(existingContract.getContractName());
    	contractDTO.setCountry(existingContract.getCountry());
    	if(existingContract.getStartDate() != null)
    	contractDTO.setStartDate(formater.format(existingContract.getStartDate()));
    	if(existingContract.getEndDate() != null)
    	contractDTO.setEndDate(formater.format(existingContract.getEndDate()));
    	
    	List<Contract> contractsList = contractService.getAll();
    	Map<String,String> contractsDD = new LinkedHashMap<String,String>();
     	for (Contract contract : contractsList) 
     	{
     		contractsDD.put(contract.getId() != null ? contract.getId().toString() : "" , contract.getContractName());
 		}
     
         map.put("contracts", contractsDD);
    	model.addAttribute("contractAttribute", contractDTO);

    	return "edit-contract";
	}
    

    /**
     * Edits an existing record
     */
   /* @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEdit(@RequestParam("id") Integer contractId, 
    						    @ModelAttribute("contractAttribute") ContractDTO contract) {
    	Contract contractModel = new Contract();
    	contractModel.setId(contractId);
    	contractModel.setContractName(contract.getContractName());
    	contractModel.setCountry(contract.getCountry());

		try {
			if (contract.getStartDate() != null)
				contractModel.setStartDate(new java.sql.Date((formater
						.parse(contract.getStartDate())).getTime()));

			if (contract.getStartDate() != null)
				contractModel.setEndDate(new java.sql.Date((formater
						.parse(contract.getEndDate())).getTime()));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    	contractModel.setContractId(contract.getContractId());
    	

    	contractService.edit(contractModel);

		return "redirect:/admin/contract/contractlist";
	}
    */

}
