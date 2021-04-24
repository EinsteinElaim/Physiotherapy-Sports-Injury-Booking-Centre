package dao;

import models.Patient;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oPatientDao implements PatientDao {

    private final Sql2o sql2o;

    public Sql2oPatientDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Patient patient) {
        String sql = "INSERT INTO patient (fullname, address, telephoneno) VALUES (:fullname, :address, :telephoneno)";
        try (Connection con = sql2o.open()){
            con.setRollbackOnException(false);
            int patientid = (int)
                    con.createQuery(sql, true)
                    .bind(patient)
                    .executeUpdate()
                    .getKey();
            patient.setPatientid(patientid);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Patient> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM patient")
                    .executeAndFetch(Patient.class);
        }
    }

    @Override
    public Patient findById(int patientid) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM patient WHERE patientid = :patientid")
                    .addParameter("patientid", patientid)
                    .executeAndFetchFirst(Patient.class);
        }
    }

    @Override
    public void update(int patientid, String fullname, String address, String telephoneno) {
        String sql = "UPDATE patient SET (fullname, address, telephoneno) = (:fullname, :address, :telephoneno) WHERE patientid =:patientid";    //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("patientid", patientid)
                    .addParameter("fullname", fullname)
                    .addParameter("address", address)
                    .addParameter("telephoneno", telephoneno)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int patientid){
        String sql = "DELETE from patient WHERE patientid = :patientid";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("patientid", patientid)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllPatients(){
        String sql = "DELETE from patient";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


}
