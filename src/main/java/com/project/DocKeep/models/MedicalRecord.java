package com.project.DocKeep.models;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Data
@Component
public class MedicalRecord {
    private String recordDate;
    private String type; // e.g., "surgery", "medication"
    private String details;
    private String doctor_name;
}
