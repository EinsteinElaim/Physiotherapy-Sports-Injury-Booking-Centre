package dao;

import models.Treatment;

import java.text.SimpleDateFormat;
import java.util.List;

public interface TreatmentDao {

    //LIST
    List<Treatment> getAll();

    //CREATE
    void add(Treatment treatment);

    //READ
    Treatment findById(int treatmentId);
    int getAllTreatmentByPatient (int patientId);

    //UPDATE
    void update(int treatmentId, String treatmentName, String room, SimpleDateFormat period, String physicianName, int patientsInTreatment);

    //DELETE
    void deleteById(int treatmentId);
    void clearAllTreatments();

}
