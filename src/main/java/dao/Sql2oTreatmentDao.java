package dao;

import models.Treatment;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.text.SimpleDateFormat;
import java.util.List;

public class Sql2oTreatmentDao implements TreatmentDao {

    private final Sql2o sql2o;

    public Sql2oTreatmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Treatment treatment) {
        String sql = "INSERT INTO treatment (treatmentName, room, period, physicianName, patientId) VALUES (:treatmentName, :room, :period, :physicianName, :patientId)";    //raw sql
        try (Connection con = sql2o.open()) {    //opening a connection
            int treatmentId = (int) con.createQuery(sql, true)   //make new variable
                    .bind(treatment)
                    .executeUpdate()    //run it all
                    .getKey();   //int id is now the row number (row "key") of db
            treatment.setTreatmentId(treatmentId); //update object to set id now from database
        } catch (Sql2oException ex) {
            System.out.println(ex);    //oops we got an error
        }
    }

    @Override
    public Treatment findById(int treatmentId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM treatment WHERE treatmentId = :treatmentId")
                    .addParameter("treatmentId", treatmentId) //key/value pair, key must match above
                    .executeAndFetchFirst(Treatment.class);  //fetch an individual item
        }
    }

    @Override
    public List<Treatment> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM treatment") //raw sql
                    .executeAndFetch(Treatment.class);   //fetch a list
        }
    }

    @Override
    public int getAllTreatmentByPatient (int patientId) {
        try(Connection con = sql2o.open()) {
            String sql = "SELECT * FROM treatment WHERE patientId = :patientId";
            return con.createQuery(sql)
                    .addParameter("patientId", patientId)
                    .executeAndFetch(Treatment.class).size();
        }
    }

    @Override
    public void update(int treatmentId, String treatmentName, String room, SimpleDateFormat period, String physicianName, int patientId) {
        String sql = "UPDATE treatment SET (treatmentName, room, period, physicianName, patientId) = (:treatmentName, :room, :period, :physicianName, :patientId) WHERE treatmentId =:treatmentId";    //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("treatmentId", treatmentId)
                    .addParameter("treatmentName", treatmentName)
                    .addParameter("room", room)
                    .addParameter("period", period)
                    .addParameter("physicianName", physicianName)
                    .addParameter("patientId", patientId)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int treatmentId) {
        String sql = "DELETE from treatment WHERE treatmentId = :treatmentId";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("treatmentId", treatmentId)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllTreatments() {
        String sql = "DELETE from treatment";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
