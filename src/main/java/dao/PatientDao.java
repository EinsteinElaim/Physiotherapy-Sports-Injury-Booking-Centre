package dao;

import models.Patient;

import java.util.List;

public interface PatientDao {

//    LIST
    List<Patient> getAll();

//    CREATE
    void add(Patient patient);

//    READ
    Patient findById(int patientid);


//    UPDATE
    void update(int patientid, String patientname, String address, String telephoneno);

//    DELETE
    void deleteById(int patientid);
    void clearAllPatients();

}
