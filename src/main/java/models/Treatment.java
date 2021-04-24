package models;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class Treatment {

    private int treatmentId;
    private String treatmentName;
    private String room;
    private SimpleDateFormat period;
    private String physicianName;
    private int patientId;

    public Treatment (int treatmentId, String treatmentName, String room, SimpleDateFormat period, String physicianName, int patientId){
        this.treatmentId = treatmentId;
        this.treatmentName = treatmentName;
        this.room = room;
        this.period = period;
        this.physicianName = physicianName;
        this.patientId = patientId;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public SimpleDateFormat getPeriod() {
        return period;
    }

    public void setPeriod(SimpleDateFormat period) {
        this.period = period;
    }

    public String getPhysicianName() {
        return physicianName;
    }

    public void setPhysicianName(String physicianName) {
        this.physicianName = physicianName;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Treatment)) return false;

        Treatment treatment = (Treatment) o;

        if (getTreatmentId() != treatment.getTreatmentId()) return false;
        if (getPatientId() != treatment.getPatientId()) return false;
        if (getTreatmentName() != null ? !getTreatmentName().equals(treatment.getTreatmentName()) : treatment.getTreatmentName() != null)
            return false;
        if (getRoom() != null ? !getRoom().equals(treatment.getRoom()) : treatment.getRoom() != null) return false;
        if (getPeriod() != null ? !getPeriod().equals(treatment.getPeriod()) : treatment.getPeriod() != null)
            return false;
        return getPhysicianName() != null ? getPhysicianName().equals(treatment.getPhysicianName()) : treatment.getPhysicianName() == null;
    }

    @Override
    public int hashCode() {
        int result = getTreatmentId();
        result = 31 * result + (getTreatmentName() != null ? getTreatmentName().hashCode() : 0);
        result = 31 * result + (getRoom() != null ? getRoom().hashCode() : 0);
        result = 31 * result + (getPeriod() != null ? getPeriod().hashCode() : 0);
        result = 31 * result + (getPhysicianName() != null ? getPhysicianName().hashCode() : 0);
        result = 31 * result + getPatientId();
        return result;
    }
}
