package com.project.DocKeep.controller;

import com.project.DocKeep.models.MedicalRecord;
import com.project.DocKeep.models.Patient;
import com.project.DocKeep.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    PatientRepository pt;
    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return pt.findAll();
    }
    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient){
        return pt.save(patient);
    }

    @GetMapping("/patient")
    public Optional<Patient> getPatient(@RequestParam("id") String id){
        return pt.findById(id);
    }

    @PostMapping("/addMedicalRecord")
    public ResponseEntity<?> addMedicalRecord(@RequestParam("id") String id, @RequestBody MedicalRecord medicalRecord){
        Optional<Patient> optionalPatient = pt.findById(id);
        if(optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            if(patient.getMedicalRecords()!=null) {
                patient.getMedicalRecords().add(medicalRecord);
            }else{
                patient.setMedicalRecords(new ArrayList<MedicalRecord>());
                patient.getMedicalRecords().add(medicalRecord);
            }
            pt.save(patient);
            return ResponseEntity.ok(patient);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
