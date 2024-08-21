package com.bms.blood.controller;

import com.bms.blood.model.BMS;
import com.bms.blood.service.BloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BloodController {
    @Autowired
    BloodService service;
    @RequestMapping("/")
    public String greet(){
        return "Welcome to the Blood Management System!";
    }
    @GetMapping("/collection")
    public ResponseEntity<List<BMS>> collection(){
        return new ResponseEntity<>(service.collection(), HttpStatus.OK);
    }

    @PostMapping("/saveCollection")
    public void addCollection(@RequestBody BMS sample){
        service.addCollection(sample);
    }

    @GetMapping("/collection/{id}")
    public ResponseEntity<BMS> getCollectionById(@PathVariable int id){
        BMS sample = service.getCollectionById(id);
        if(sample!=null) {
            return new ResponseEntity<>(sample, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/collection/{blood}")
    public BMS getSampleByGroup(@PathVariable String blood){
        BMS sample = service.getSampleByGroup(blood);
        return sample;
    }
}
