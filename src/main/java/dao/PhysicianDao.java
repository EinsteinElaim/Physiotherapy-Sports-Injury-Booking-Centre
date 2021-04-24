package dao;

import models.Physician;

import java.util.List;

public interface PhysicianDao {

    //    LIST
    List<Physician> getAll();

    //    CREATE
    void add(Physician physician);

    //    READ
    Physician findById(int physicianId);


    //    UPDATE
    void update(int physicianId, String fullName, String address, String telephoneNo, String experticeAreas);

    //    DELETE
    void deleteById(int physicianId);
    void clearAllPhysicians();

}
