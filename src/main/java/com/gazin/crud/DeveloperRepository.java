package com.gazin.crud;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DeveloperRepository extends JpaRepository<Developer, Long>{
	
	List<Developer> findAll();
}
