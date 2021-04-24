package models;

public class Visitor {

    private  int visitorId;
    private String fullName;
    private String address;
    private String telephoneNo;

    public Visitor (int visitorId, String fullName, String address, String telephoneNo){
        this.visitorId = visitorId;
        this.fullName = fullName;
        this.address = address;
        this.telephoneNo = telephoneNo;
    }

    public int getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(int visitorId) {
        this.visitorId = visitorId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visitor)) return false;

        Visitor visitor = (Visitor) o;

        if (getVisitorId() != visitor.getVisitorId()) return false;
        if (getFullName() != null ? !getFullName().equals(visitor.getFullName()) : visitor.getFullName() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(visitor.getAddress()) : visitor.getAddress() != null)
            return false;
        return getTelephoneNo() != null ? getTelephoneNo().equals(visitor.getTelephoneNo()) : visitor.getTelephoneNo() == null;
    }

    @Override
    public int hashCode() {
        int result = getVisitorId();
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getTelephoneNo() != null ? getTelephoneNo().hashCode() : 0);
        return result;
    }
}
