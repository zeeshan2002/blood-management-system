package com.bms.blood.service;

import com.bms.blood.model.BMS;
import com.bms.blood.repo.BloodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BloodService {
    @Autowired
    BloodRepo repo;
    public List<BMS> collection(){
        return repo.findAll();
    }

    public void addCollection(BMS sample) {
        repo.save(sample);
    }

    public BMS getCollectionById(int id) {
            return repo.findById(id).orElse(null);
    }

    public BMS getSampleByGroup(String blood){
        BMS sample = repo.findByBloodgroup(blood);
        return sample;
    }
}
