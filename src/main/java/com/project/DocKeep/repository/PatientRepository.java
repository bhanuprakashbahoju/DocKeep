package com.project.DocKeep.repository;

import com.project.DocKeep.models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface PatientRepository extends MongoRepository<Patient,String> {
}
