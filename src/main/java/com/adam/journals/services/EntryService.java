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
    
//    public List<Entry> getEntriesByKeywords(Long userID) {
//    	
//    	String stringUserId = String.valueOf(userID);
//    	
//    	return entryRepo.getEntriesByKeywords(stringUserId);
//    }
	
	//  ***Update***
	
    public Entry editEntry(Entry entry) {
		return entryRepo.save(entry);
	}
	
	//   ***Delete***
    
    public void destroy(Long id) {
		entryRepo.deleteById(id);
	}    
    
}
