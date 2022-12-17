// Name: Vineeth Kumar Ananthula UTA ID: 1001953922

package com.inputvalidator.phonebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PhoneBook {

	@Id
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String phone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
