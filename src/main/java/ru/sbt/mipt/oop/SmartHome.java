package ru.sbt.mipt.oop;


import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

public class SmartHome implements Functionable{

    Collection<Room> rooms;

    private AlarmSystem alarmSystem;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public AlarmSystem getAlarmSystem() {
        return alarmSystem;
    }

    public void setAlarmSystem(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void executeFunc(Function<Object, Void> function) {
        for (Room room: rooms) {
            room.executeFunc(function);
        }
        if (alarmSystem != null) {
            alarmSystem.executeFunc(function);
        }
        function.apply(this);
    }
}
