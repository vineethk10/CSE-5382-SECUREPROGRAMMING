// Name: Vineeth Kumar Ananthula UTA ID: 1001953922

package com.inputvalidator.phonebook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inputvalidator.phonebook.entity.Auditlog;

@Repository
public interface AuditlogRepository  extends JpaRepository<Auditlog, Integer> {
	
	@Query(value = "select max(p.id) from Auditlog p")
	public Integer findMaxId();
	
	@Query(value = "select p from Auditlog p")
	public List<Auditlog> findAllLogs();
}
