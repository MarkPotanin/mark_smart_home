package ru.sbt.mipt.oop.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.DoorIterator;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class DoorIteratorTest {
    @Test
    public void Test(){
        SmartHome smartHome = new SmartHome();
        String doorId1 = "1";
        String doorId2 = "2";
        String doorId3 = "3";
        String doorId4 = "4";
        Door door1 = new Door(doorId1, false);
        Door door2 = new Door(doorId2, false);
        Door door3 = new Door(doorId3, false);
        Door door4 = new Door(doorId4, false);
        Room room = new Room(Collections.emptyList(),
            Arrays.asList(door1, door2, door3, door4),
            "hall");
        smartHome.addRoom(room);
        List<Object> objectList = new ArrayList<>();
        objectList.add(door1);
        objectList.add(door2);
        objectList.add(door3);
        objectList.add(door4);
        new DoorIterator(smartHome).handleFunction(door -> {
            objectList.remove(door);
            return null;
        });
        assertEquals(0, objectList.size());
    }
}
