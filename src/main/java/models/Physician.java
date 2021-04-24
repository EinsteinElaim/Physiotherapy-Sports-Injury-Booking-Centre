package models;

public class Physician {

    private int physicianId;
    private String fullName;
    private String address;
    private String telephoneNo;
    private String experticeAreas;

    public Physician (int physicianId, String fullName, String address, String telephoneNo, String experticeAreas){

        this.physicianId = physicianId;
        this.fullName = fullName;
        this.address = address;
        this.telephoneNo = telephoneNo;
        this.experticeAreas = experticeAreas;

    }

    public int getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(int physicianId) {
        this.physicianId = physicianId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getExperticeAreas() {
        return experticeAreas;
    }

    public void setExperticeAreas(String experticeAreas) {
        this.experticeAreas = experticeAreas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Physician)) return false;

        Physician physician = (Physician) o;

        if (getPhysicianId() != physician.getPhysicianId()) return false;
        if (getFullName() != null ? !getFullName().equals(physician.getFullName()) : physician.getFullName() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(physician.getAddress()) : physician.getAddress() != null)
            return false;
        if (getTelephoneNo() != null ? !getTelephoneNo().equals(physician.getTelephoneNo()) : physician.getTelephoneNo() != null)
            return false;
        return getExperticeAreas() != null ? getExperticeAreas().equals(physician.getExperticeAreas()) : physician.getExperticeAreas() == null;
    }

    @Override
    public int hashCode() {
        int result = getPhysicianId();
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getTelephoneNo() != null ? getTelephoneNo().hashCode() : 0);
        result = 31 * result + (getExperticeAreas() != null ? getExperticeAreas().hashCode() : 0);
        return result;
    }
}
