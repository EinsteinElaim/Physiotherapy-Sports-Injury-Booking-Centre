import dao.*;
import org.sql2o.Sql2o;
import dao.Sql2oPatientDao;
import dao.Sql2oPhysicianDao;
import dao.Sql2oRoomDao;
import dao.Sql2oTreatmentDao;
import dao.Sql2oVisitorDao;
import models.Patient;
import models.Physician;
import models.Room;
import models.Treatment;
import models.Visitor;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    static  int getRunnerPort(){
        return 4567;        //return default port  ie. on localhost
    }

    public static void main(String[] args) {
        port(getRunnerPort());
        String connectionString = "jdbc:postgresql://localhost:5432/physiotherapy_and_sports_injury_booking";
        Sql2o sql2o = new Sql2o(connectionString, "einstein", "6889");
        System.out.println("Database login successful");
        Sql2oPatientDao patientDao = new Sql2oPatientDao(sql2o);
        Sql2oPhysicianDao physicianDao = new Sql2oPhysicianDao(sql2o);
        Sql2oRoomDao roomDao = new Sql2oRoomDao(sql2o);
        Sql2oTreatmentDao treatmentDao = new Sql2oTreatmentDao(sql2o);
        Sql2oVisitorDao visitorDao = new Sql2oVisitorDao(sql2o);


//        get: show all patients, physicians, rooms, treatments, visitors
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Patient> allPatients = patientDao.getAll();
            model.put("patients", allPatients);
            List<Physician> allPhysicians = physicianDao.getAll();
            model.put("physicians", allPhysicians);
            List<Room> allRooms = roomDao.getAll();
            model.put("rooms", allRooms);
            List<Treatment> allTreatments = treatmentDao.getAll();
            model.put("treatments", allTreatments);
            List<Visitor> allVisitors = visitorDao.getAll();
            model.put("visitors", allVisitors);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());



//        patient
//        get:show form to create new Patient
        get("/patients/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Patient> patients = patientDao.getAll();
            model.put("patients", patients);
            return new ModelAndView(model, "patient-form.hbs");
        }, new HandlebarsTemplateEngine());

//        process a form to create new patient
        post("/patients", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Patient> allPatients = patientDao.getAll();
            model.put("patients", allPatients);
            String fullname = request.queryParams("fullname");
            String address = request.queryParams("address");
            String telephoneno = request.queryParams("telephoneno");
            Patient newPatient = new Patient(fullname, address, telephoneno);
            patientDao.add(newPatient);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

//        show a form to update a patient
        get("/patients/:patientid/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Patient> allPatients = patientDao.getAll();
            model.put("patients", allPatients);
            Patient patient = patientDao.findById(Integer.parseInt(request.params("patientid")));
            model.put("patient", patient);
            model.put("editPatient", true);
            return new ModelAndView(model, "patient-form.hbs");
        });

//        process a form to update a patient
        post("/patients/:patientid", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int patientToEditId = Integer.parseInt(request.params("patientid"));
            String newfullname = request.queryParams("fullname");
            String newaddress = request.queryParams("address");
            String newtelephoneno = request.queryParams("telephoneno");
            patientDao.update(patientToEditId, newfullname, newaddress, newtelephoneno);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

//        get:delete all patients
        get("/patients/delete", (request, response) -> {
            patientDao.clearAllPatients();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

//        get:delete individual patient
        get("/patients/:patientid/delete", (request, response) -> {
            int idOfPatientToDelete = Integer.parseInt(request.params("patientid"));
            patientDao.deleteById(idOfPatientToDelete);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());




//        routes and layouts for Physician,
//        Rooms,
//        Treatment,
//        Visitor remaining

    }

}
