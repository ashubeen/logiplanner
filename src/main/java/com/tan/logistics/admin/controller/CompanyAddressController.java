package com.tan.logistics.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tan.logistics.admin.model.CompanyAddress;
import com.tan.logistics.admin.request.CompanyAddressRequest;
import com.tan.logistics.admin.request.CompanyRequest;
import com.tan.logistics.admin.response.LogisticsResponse;
import com.tan.logistics.admin.service.CompanyAddressService;
import com.tan.logistics.admin.service.CompanyService;

@Controller
@RequestMapping("/admin/companyAddress")
public class CompanyAddressController {

	@Resource(name = "companyService")
	private CompanyService compService;

	
	@Resource(name = "companyAddressService")
	private CompanyAddressService companyAddressService;

	@RequestMapping(value = "/listAddress", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<CompanyAddress> listAddress(@RequestBody CompanyRequest request) {

		
		LogisticsResponse<CompanyAddress> response = new LogisticsResponse<CompanyAddress>();
		response.setRecords(companyAddressService.getAll(request.getId()));
		response.setResult("OK");
		return response;
	}

	/**
	 * Adds a new credit card
	 */
	
	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<CompanyAddress> postAdd(@RequestBody CompanyAddressRequest request) {
	
		companyAddressService.add(request.getId(), request.getRecord());
		LogisticsResponse<CompanyAddress> response = new LogisticsResponse<CompanyAddress>();
		response.setResult("OK");
		response.setRecord(request.getRecord());
    	return response;
	
	}
	
	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<CompanyAddress> update(@RequestBody CompanyAddressRequest request) {

		companyAddressService.edit(request.getRecord());
		LogisticsResponse<CompanyAddress> response = new LogisticsResponse<CompanyAddress>();
		response.setResult("OK");
		return response;
	}

	@RequestMapping(value = "/deleteAddress", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<CompanyAddress> delete(@RequestBody CompanyAddressRequest request) {

		companyAddressService.delete(request.getId());
		LogisticsResponse<CompanyAddress> t = new LogisticsResponse<CompanyAddress>();
		t.setResult("OK");
		return t;
	}

	/*
	@RequestMapping(value = "/editaddress", method = RequestMethod.POST)
	public String postEdit(
			@RequestParam("id") Integer addressId,
			@ModelAttribute("companyAddressAttribute") CompanyAddress companyAddress) {

		// Assign id
		companyAddress.setId(addressId);

		// Delegate to service
		companyAddressService.edit(companyAddress);
		// Redirect to url
		return "redirect:/admin/oldcompany/companylist";
	}

	/*
	 * @RequestMapping(value = "/addaddress", method = RequestMethod.GET) public
	 * String getAdd(@RequestParam("id") Integer companyId, Model model) {
	 * 
	 * CompanyAddress companyAddress = new CompanyAddress();
	 * model.addAttribute("companyId", companyId);
	 * model.addAttribute("companyAddressAttribute", companyAddress); return
	 * "addcompanyaddress"; }
	 * 
	 * 
	 * @RequestMapping(value = "/editaddress", method = RequestMethod.GET)
	 * public String getEdit(@RequestParam("cid") Integer companyId,
	 * 
	 * @RequestParam("aid") Integer addressId, Model model) {
	 * 
	 * CompanyAddress existringCompanyAddress = companyAddressService
	 * .get(addressId); // Add to model model.addAttribute("companyId",
	 * companyId); model.addAttribute("companyAddressAttribute",
	 * existringCompanyAddress);
	 * 
	 * // This will resolve to /WEB-INF/jsp/edit-credit-card.jsp return
	 * "editcompanyaddress"; }
	 */
}
