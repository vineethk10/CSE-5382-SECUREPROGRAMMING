// Name: Vineeth Kumar Ananthula UTA ID: 1001953922

package com.inputvalidator.phonebook.services;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inputvalidator.phonebook.entity.Auditlog;
import com.inputvalidator.phonebook.entity.PhoneBook;
import com.inputvalidator.phonebook.repositories.AuditlogRepository;
import com.inputvalidator.phonebook.repositories.PhoneBookRepository;
import com.inputvalidator.phonebook.validators.NameValidator;
import com.inputvalidator.phonebook.validators.PhoneValidator;


@Service
public class PhoneBookService {

	@Autowired
	private PhoneBookRepository phoneBookRepository;

	@Autowired
	private AuditlogRepository auditlogRepository;

	public List<PhoneBook> getAllMembers() {
		List<PhoneBook> list = phoneBookRepository.findAll();
		saveAuditlog("SYSTEM", "GET");
		return list;
	}

	public ResponseEntity validateAndAddToDB(PhoneBook phoneBookEntity) throws Exception {
		Boolean validPh = false;
		Boolean validName = false;

		if ((phoneBookEntity.getName() == null || phoneBookEntity.getName().trim().length() == 0)
				|| (phoneBookEntity.getPhone() == null || phoneBookEntity.getPhone().trim().length() == 0)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid String");
		}

		validName = NameValidator.isValidName(phoneBookEntity.getName());
		validPh = PhoneValidator.isValidPhone(phoneBookEntity.getPhone());

		if (validName && validPh) {
			if (!checkNumberExist(phoneBookEntity.getPhone())) {
				phoneBookEntity
						.setId(null == phoneBookRepository.findMaxId() ? 1 : phoneBookRepository.findMaxId() + 1);
				PhoneBook phonebook = phoneBookRepository.save(phoneBookEntity);
				saveAuditlog(phoneBookEntity.getName(), "ADD");
				return ResponseEntity.ok(phonebook);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Phone number already exist");
			}

		} else {
			if (!validName)
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid name format supplied");
			if (!validPh)
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid phone number format supplied");
		}
		throw new Exception("InValid String");

	}

	public ResponseEntity deleteMemberByName(String name) {
		if (NameValidator.isValidName(name)) {
			List<PhoneBook> phoneBooks = phoneBookRepository.findAllByName(name);
			if (phoneBooks.size() > 0) {
				phoneBookRepository.deleteAll(phoneBooks);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Records found");
			}
			saveAuditlog(name, "DELETE");
			return ResponseEntity.ok(String.format("Number of records deleted successfully: %s", phoneBooks.size()));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid name format supplied");
		}
	}

	public ResponseEntity deleteMemberByNumber(String number) {
		if (PhoneValidator.isValidPhone(number)) {
			List<PhoneBook> phoneBooks = phoneBookRepository.findAllByPhone(number);
			if (phoneBooks.size() > 0) {
				phoneBookRepository.deleteAll(phoneBooks);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Records found");
			}
			saveAuditlog(number, "DELETE");
			return ResponseEntity.ok(String.format("Number of records deleted successfully: %s", phoneBooks.size()));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid phone number format supplied");
		}
	}

	public ResponseEntity getAuditList() {
		return ResponseEntity.ok(auditlogRepository.findAll());
	}

	private Auditlog saveAuditlog(String name, String operation) {
		Auditlog auditlog = new Auditlog();
		auditlog.setName(name);
		auditlog.setOperation(operation);
		auditlog.setTime(Instant.now());
		auditlog.setId((null == auditlogRepository.findMaxId() ? 1 : auditlogRepository.findMaxId() + 1));
		return auditlogRepository.save(auditlog);
	}

	private boolean checkNumberExist(String phone) {
		List<PhoneBook> phoneBookList = phoneBookRepository.findAllByPhone(phone);
		return phoneBookList.size() > 0 ? true : false;
	}

}
