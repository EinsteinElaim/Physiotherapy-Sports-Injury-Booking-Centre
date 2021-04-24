package dao;

import models.Room;

import java.util.List;

public interface RoomDao {

    //    LIST
    List<Room> getAll();

    //    CREATE
    void add(Room room);

    //    READ
    Room findById(int roomId);


    //    UPDATE
    void update(int roomId, String roomName);

    //    DELETE
    void deleteById(int roomId);
    void clearAllRooms();

}
