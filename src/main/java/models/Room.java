package models;

public class Room {

    private int roomId;
    private String roomName;

    public Room (int roomId, String roomName){
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (getRoomId() != room.getRoomId()) return false;
        return getRoomName() != null ? getRoomName().equals(room.getRoomName()) : room.getRoomName() == null;
    }

    @Override
    public int hashCode() {
        int result = getRoomId();
        result = 31 * result + (getRoomName() != null ? getRoomName().hashCode() : 0);
        return result;
    }
}
