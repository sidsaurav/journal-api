package com.sidsaurav.journalApp.controller;


import com.sidsaurav.journalApp.entity.JournalEntry;
import com.sidsaurav.journalApp.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String deleteJournal(@PathVariable String id) {
        try{
            journalRepo.deleteById(id);
            return "Journal Deleted Successfully";
        }
        catch(Exception e){
            return e.getMessage();
        }
    }
}
