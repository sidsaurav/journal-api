package com.sidsaurav.journalApp.controller;


import com.sidsaurav.journalApp.entity.JournalEntry;
import com.sidsaurav.journalApp.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Journal {

    @Autowired
    private JournalRepository journalRepo;

    @GetMapping("/journals")
    public List<JournalEntry> getAllJournalEntries(){
        return journalRepo.findAll();
    }

    @GetMapping("/journal/{id}")
    public JournalEntry getJournalById(@PathVariable String id) {
        return journalRepo.findById(id).orElse(null);
    }

    @PostMapping("/journal")
    public JournalEntry postJournal(@RequestBody JournalEntry req) {
        return journalRepo.save(req);
    }

}
