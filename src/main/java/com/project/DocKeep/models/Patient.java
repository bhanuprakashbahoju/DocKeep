package com.project.DocKeep.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "patients")
public class Patient{
    @Id
    private String id;
    private String name;
    private String dateOfBirth;
    private String gender; // e.g., "male", "female", "other"
    private String contactInfo;
    private List<MedicalRecord> medicalRecords;
}
