package com.tan.logistics.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tan.logistics.admin.model.PersonAddress;
import com.tan.logistics.admin.request.PersonAddressRequest;
import com.tan.logistics.admin.request.PersonRequest;
import com.tan.logistics.admin.response.LogisticsResponse;
import com.tan.logistics.admin.service.PersonAddressService;
import com.tan.logistics.admin.service.PersonService;
import com.tan.logistics.admin.service.PersonService;

@Controller
@RequestMapping("/admin/personAddress")
public class PersonAddressController {

	@Resource(name="personService")
    private PersonService personService;
	
	@Resource(name = "personAddressService")
	private PersonAddressService personAddressService;

	@RequestMapping(value = "/listAddress", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<PersonAddress> listAddress(@RequestBody PersonRequest request) {

		
		LogisticsResponse<PersonAddress> response = new LogisticsResponse<PersonAddress>();
		response.setRecords(personAddressService.getAll(request.getId()));
		response.setResult("OK");
		return response;
	}

	/**
	 * Adds a new credit card
	 */
	
	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<PersonAddress> postAdd(@RequestBody PersonAddressRequest request) {
	
		personAddressService.add(request.getId(), request.getRecord());
		LogisticsResponse<PersonAddress> response = new LogisticsResponse<PersonAddress>();
		response.setResult("OK");
		response.setRecord(request.getRecord());
    	return response;
	
	}
	
	@RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<PersonAddress> update(@RequestBody PersonAddressRequest request) {

		personAddressService.edit(request.getRecord());
		LogisticsResponse<PersonAddress> response = new LogisticsResponse<PersonAddress>();
		response.setResult("OK");
		return response;
	}

	@RequestMapping(value = "/deleteAddress", method = RequestMethod.POST)
	public @ResponseBody
	LogisticsResponse<PersonAddress> delete(@RequestBody PersonAddressRequest request) {

		personAddressService.delete(request.getId());
		LogisticsResponse<PersonAddress> t = new LogisticsResponse<PersonAddress>();
		t.setResult("OK");
		return t;
	}

	/*
	@RequestMapping(value = "/editaddress", method = RequestMethod.POST)
	public String postEdit(
			@RequestParam("id") Integer addressId,
			@ModelAttribute("personAddressAttribute") PersonAddress personAddress) {

		// Assign id
		personAddress.setId(addressId);

		// Delegate to service
		personAddressService.edit(personAddress);
		// Redirect to url
		return "redirect:/admin/oldperson/personlist";
	}

	/*
	 * @RequestMapping(value = "/addaddress", method = RequestMethod.GET) public
	 * String getAdd(@RequestParam("id") Integer personId, Model model) {
	 * 
	 * PersonAddress personAddress = new PersonAddress();
	 * model.addAttribute("personId", personId);
	 * model.addAttribute("personAddressAttribute", personAddress); return
	 * "addpersonaddress"; }
	 * 
	 * 
	 * @RequestMapping(value = "/editaddress", method = RequestMethod.GET)
	 * public String getEdit(@RequestParam("cid") Integer personId,
	 * 
	 * @RequestParam("aid") Integer addressId, Model model) {
	 * 
	 * PersonAddress existringPersonAddress = personAddressService
	 * .get(addressId); // Add to model model.addAttribute("personId",
	 * personId); model.addAttribute("personAddressAttribute",
	 * existringPersonAddress);
	 * 
	 * // This will resolve to /WEB-INF/jsp/edit-credit-card.jsp return
	 * "editpersonaddress"; }
	 */
}
