package com.sidsaurav.journalApp.controller;


import com.sidsaurav.journalApp.entity.JournalEntry;
import com.sidsaurav.journalApp.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
public class JournalController {

    @Autowired
    private JournalRepository journalRepo;

    // GET ALL
    @GetMapping("/journals")
    public List<JournalEntry> getAllJournalEntries(){
        return journalRepo.findAll();
    }

    // GET ONE
    @GetMapping("/journal/{id}")
    public JournalEntry getJournalById(@PathVariable String id) {
        return journalRepo.findById(id).orElse(null);
    }

    // POST ONE
    @PostMapping("/journal")
    public JournalEntry postJournal(@RequestBody JournalEntry req){
        req.setCreated_at(LocalDateTime.now());
        return journalRepo.save(req);
    }

    // DELETE ONE
    @DeleteMapping("/journal/{id}")
    public ResponseEntity<String> deleteJournal(@PathVariable String id) {
        var item = journalRepo.findById(id);
        if(item.isEmpty()){
            return new ResponseEntity<>("Item not found", HttpStatus.ACCEPTED);
        }
        else{
            journalRepo.deleteById(id);
            return new ResponseEntity<>("deleted", HttpStatus.ACCEPTED);
        }
    }
}
