// Name: Vineeth Kumar Ananthula UTA ID: 1001953922

package com.inputvalidator.phonebook.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Auditlog {
	@Id
	private int id;
	
	private String name;
	
	private String operation;
	
	private Instant time;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

}
