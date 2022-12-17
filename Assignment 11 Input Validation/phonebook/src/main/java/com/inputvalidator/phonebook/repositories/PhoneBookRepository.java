// Name: Vineeth Kumar Ananthula UTA ID: 1001953922

package com.inputvalidator.phonebook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.inputvalidator.phonebook.entity.PhoneBook;

@Repository
public interface PhoneBookRepository extends JpaRepository<PhoneBook, Integer> {

	@Query(value = "select p from PhoneBook p where p.name = ?1")
	public List<PhoneBook> findAllByName(String name);

	@Query(value = "select p from PhoneBook p where p.phone = ?1")
	public List<PhoneBook> findAllByPhone(String phone);

	@Query(value = "select max(p.id) from PhoneBook p")
	public Integer findMaxId();

}
