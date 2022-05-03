package com.adam.journals.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adam.journals.models.Entry;
import com.adam.journals.repositories.EntryRepository;

@Service
public class EntryService {

	@Autowired
	EntryRepository entryRepo;

	//  ***Create***
	
    public Entry createEntry(Entry entry) {
        return entryRepo.save(entry);
    }
	
	//  ***Retrieve***
	
    public Entry findEntry(Long id) {
        Optional<Entry> optionalEntry = entryRepo.findById(id);
        if(optionalEntry.isPresent()) {
            return optionalEntry.get();
        } 
        else {
            return null;
        }
    }
    
    public List<Entry> getEntriesByMonth(Long year, Long month, Long userId) {
    	String stringYear = String.valueOf(year);
    	String stringMonth = String.valueOf(month);
    	String stringUserId = String.valueOf(userId);
    	
    	return entryRepo.getEntriesByMonth(stringYear, stringMonth, stringUserId);
    }
    
    public List<Entry> getEntriesByKeywords(Long userID, String keywords) {
    	String stringUserId = String.valueOf(userID);
//    	String querySearch = "SELECT * FROM entries WHERE user_id = " + userID +  " AND entry LIKE ";
    
        String querySearch = "%";
        
        for( int i = 0; i < keywords.length(); i++){
            char check = keywords.charAt(i);
            if( Character.isWhitespace(check)) {
                querySearch += "% OR entry LIKE %";
            }
            else{
                querySearch += check ;
            }
        }
        querySearch += "%";

    	System.out.println(keywords);
    	System.out.println(querySearch);
    	
    	return entryRepo.getEntriesByKeywords(stringUserId, querySearch);
    }
	
	//  ***Update***
	
    public Entry editEntry(Entry entry) {
		return entryRepo.save(entry);
	}
	
	//   ***Delete***
    
    public void destroy(Long id) {
		entryRepo.deleteById(id);
	}    
    
}
