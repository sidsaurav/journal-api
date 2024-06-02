package com.sidsaurav.journalApp.repository;

import com.sidsaurav.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalRepository extends MongoRepository<JournalEntry, String> {

}
