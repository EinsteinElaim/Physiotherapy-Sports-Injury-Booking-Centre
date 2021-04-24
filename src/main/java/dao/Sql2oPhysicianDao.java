package dao;

import models.Physician;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oPhysicianDao implements PhysicianDao {

    private final Sql2o sql2o;

    public Sql2oPhysicianDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Physician physician) {
        String sql = "INSERT INTO physician (fullName, address, telephoneNo, experticeAreas) VALUES (:fullName, :address, :telephoneNo, :experticeAreas)";    //raw sql
        try (Connection con = sql2o.open()) {    //opening a connection
            int physicianId = (int) con.createQuery(sql, true)   //make new variable
                    .bind(physician)
                    .executeUpdate()
                    .getKey();
            physician.setPhysicianId(physicianId);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Physician findById(int physicianId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM physician WHERE physicianId = :physicianId")
                    .addParameter("physicianId", physicianId)
                    .executeAndFetchFirst(Physician.class);
        }
    }

    @Override
    public List<Physician> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM physician")
                    .executeAndFetch(Physician.class);
        }
    }

    @Override
    public void update(int physicianId, String fullName, String address, String telephoneNo, String experticeAreas) {
        String sql = "UPDATE patient SET (fullName, address, telephoneNo, experticeAreas) = (:fullName, :address, :telephoneNo, :experticeAreas) WHERE patientId =:patientId";    //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("physicianId", physicianId)
                    .addParameter("fullName", fullName)
                    .addParameter("address", address)
                    .addParameter("telephoneNo", telephoneNo)
                    .addParameter("experticeAreas", experticeAreas)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int physicianId) {
        String sql = "DELETE from physician WHERE physicianId = :physicianId";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("physicianId", physicianId)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllPhysicians() {
        String sql = "DELETE from physician";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
