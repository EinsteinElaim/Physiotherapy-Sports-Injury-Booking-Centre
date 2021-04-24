package dao;

import models.Visitor;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oVisitorDao implements VisitorDao {

    private Sql2o sql2o;
    public Sql2oVisitorDao (Sql2o sql2o) {this.sql2o = sql2o;}


    @Override
    public void add(Visitor visitor) {
        String sql = "INSERT INTO visitor (visitorId, fullName, address, telephoneNo) VALUES (:visitorId, :fullName, :address, :telephoneNo)";    //raw sql
        try (Connection con = sql2o.open()) {    //opening a connection
            int visitorId = (int) con.createQuery(sql, true)   //make new variable
                    .bind(visitor)
                    .executeUpdate()
                    .getKey();
            visitor.setVisitorId(visitorId);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Visitor findById(int visitorId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM visitor WHERE visitorId = :visitorId")
                    .addParameter("roomId", visitorId)
                    .executeAndFetchFirst(Visitor.class);
        }
    }

    @Override
    public List<Visitor> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM visitor")
                    .executeAndFetch(Visitor.class);
        }
    }

    @Override
    public void update(int visitorId, String fullName, String address, String telephoneNo) {
        String sql = "UPDATE visitor SET (fullName, address, telephoneNo) = (:fullName, :address, :telephoneNo) WHERE visitorId =:visitorId";    //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("visitorId", visitorId)
                    .addParameter("fullName", fullName)
                    .addParameter("address", address)
                    .addParameter("telephoneNo", telephoneNo)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int visitorId) {
        String sql = "DELETE from visitor WHERE visitorId = :visitorId";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("visitorId", visitorId)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllVisitors() {
        String sql = "DELETE from visitor";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
