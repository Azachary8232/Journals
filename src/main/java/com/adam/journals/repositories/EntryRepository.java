package com.adam.journals.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adam.journals.models.Entry;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Long>{

//  ***Create***


//  ***Retrieve***

	@Query(value="SELECT * FROM entries WHERE user_id = :userId AND year(entry_date) = :year AND month(entry_date) = :month ORDER BY entry_date asc", nativeQuery=true)
	List<Entry> getEntriesByMonth(String year, String month, String userId);

//  ***Update***


//   ***Delete***
	
	
	
}