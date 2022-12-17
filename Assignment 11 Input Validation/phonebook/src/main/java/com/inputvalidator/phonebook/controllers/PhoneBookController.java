// Name: Vineeth Kumar Ananthula UTA ID: 1001953922

package com.inputvalidator.phonebook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inputvalidator.phonebook.entity.PhoneBook;
import com.inputvalidator.phonebook.services.PhoneBookService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/PhoneBook")
public class PhoneBookController {
	
	@Autowired
	private PhoneBookService phoneBookService;
	
	@Operation(summary="Get all Phonebook list", description="Get all Phonebook list")
	@GetMapping(path="/list")
	public List<PhoneBook> getListOfMembers() {
		return phoneBookService.getAllMembers();
	}
	
	@Operation(summary="Add a Phonebook entry", description="Add a Phonebook entry")
	@PostMapping(path="/add")
	public ResponseEntity addMember(@RequestBody PhoneBook phonebookEntity) throws Exception {
		return phoneBookService.validateAndAddToDB(phonebookEntity);
	}
	
	@Operation(summary="Delete entries by name", description="Delete entries by name")
	@PutMapping(path="/deleteByName/{name}")
	public ResponseEntity deleteMemberByName(@PathVariable String name) throws Exception {
		return phoneBookService.deleteMemberByName(name);
	}
	
	@Operation(summary="Delete entries by number", description="Delete entries by number")
	@PutMapping(path="/deleteByNumber/{number}")
	public ResponseEntity deleteMemberByNumber(@PathVariable String number) throws Exception {
		return phoneBookService.deleteMemberByNumber(number);
	}
	
	@Operation(summary="Get AuditLog list", description="Get AuditLog list")
	@GetMapping(path="/list/audit")
	public ResponseEntity getAuditLogList() {
		return phoneBookService.getAuditList();
	}

}
