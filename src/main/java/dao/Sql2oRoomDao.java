package dao;

import models.Room;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oRoomDao implements RoomDao {

    private final Sql2o sql2o;

    public Sql2oRoomDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Room room) {
        String sql = "INSERT INTO room (roomId, roomName) VALUES (:roomId, :roomName)";    //raw sql
        try (Connection con = sql2o.open()) {    //opening a connection
            int roomId = (int) con.createQuery(sql, true)   //make new variable
                    .bind(room)
                    .executeUpdate()
                    .getKey();
            room.setRoomId(roomId);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Room findById(int roomId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM room WHERE roomId = :roomId")
                    .addParameter("roomId", roomId)
                    .executeAndFetchFirst(Room.class);
        }
    }

    @Override
    public List<Room> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM room")
                    .executeAndFetch(Room.class);
        }
    }

    @Override
    public void update(int roomId, String roomName) {
        String sql = "UPDATE room SET (roomName) = (:roomName) WHERE roomId =:roomId";    //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("roomId", roomId)
                    .addParameter("roomName", roomName)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int roomId) {
        String sql = "DELETE from room WHERE roomId = :roomId";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("roomId", roomId)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllRooms() {
        String sql = "DELETE from room";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
