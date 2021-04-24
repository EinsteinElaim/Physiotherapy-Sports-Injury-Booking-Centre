package dao;

import models.Visitor;

import java.util.List;

public interface VisitorDao {

    //LIST
    List<Visitor> getAll();

    //CREATE
    void add(Visitor visitor);

    //READ
    Visitor findById(int visitorId);

    //UPDATE
    void update(int visitorId, String fullName, String address, String telephoneNo);

    //DELETE
    void deleteById(int visitorId);
    void clearAllVisitors();

}
