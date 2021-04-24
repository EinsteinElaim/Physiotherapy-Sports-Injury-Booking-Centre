package models;

public class Patient {

    private int patientid;
    private String fullname;
    private String address;
    private String telephoneno;

    public Patient (String fullname, String address, String telephoneno){
        this.fullname = fullname;
        this.address = address;
        this.telephoneno = telephoneno;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneno() {
        return telephoneno;
    }

    public void setTelephoneno(String telephoneno) {
        this.telephoneno = telephoneno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        if (getPatientid() != patient.getPatientid()) return false;
        if (getFullname() != null ? !getFullname().equals(patient.getFullname()) : patient.getFullname() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(patient.getAddress()) : patient.getAddress() != null)
            return false;
        return getTelephoneno() != null ? getTelephoneno().equals(patient.getTelephoneno()) : patient.getTelephoneno() == null;
    }

    @Override
    public int hashCode() {
        int result = getPatientid();
        result = 31 * result + (getFullname() != null ? getFullname().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getTelephoneno() != null ? getTelephoneno().hashCode() : 0);
        return result;
    }
}
