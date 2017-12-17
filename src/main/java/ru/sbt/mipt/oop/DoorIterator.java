package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class DoorIterator implements Iterator<Door>, IteratorFunction<Door> {

    private List<Room> roomList;
    private int roomPosition;
    private int doorPosition;

    public DoorIterator(SmartHome smartHome) {
        roomList = new ArrayList<>(smartHome.getRooms());
    }

    @Override
    public boolean hasNext() {
        if (roomPosition <= roomList.size() - 1) {
            if (doorPosition <= roomList.get(roomPosition).getDoors().size() - 1) {
                return true;
            } else {
                roomPosition++;
                doorPosition = 0;
                return hasNext();
            }
        }
        return false;
    }

    @Override
    public Door next() {
        if (hasNext()) {
            List<Door> doorList = new ArrayList<>(roomList.get(roomPosition).getDoors());
            Door door = doorList.get(doorPosition);
            doorPosition++;
            return door;
        } else {
            throw new IllegalStateException();
        }
    }


    public Room getCurrentRoom() {
        if (roomPosition <= roomList.size() - 1) return roomList.get(roomPosition);
        else return null;
    }

    @Override
    public void handleFunction(Function<Door, Void> func) {
        while(hasNext()) {
            Door door = next();
            func.apply(door);
        }
    }
}
