package ru.sbt.mipt.oop.test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.DoorHandler;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;


public class DoorHandlerTest {
    @Test
    public void test1() throws Exception {
        DoorHandler doorHandler = new DoorHandler();
        SmartHome home = new SmartHome();
        String doorId = "1";
        Door door = new Door(doorId,false);
        home.addRoom(new Room(Collections.emptyList(),
                Arrays.asList(door),
            "hall"));
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_OPEN, doorId);
        doorHandler.handleEvent(event);
        event = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId);
        doorHandler.handleEvent(event);
        assertFalse(door.isOpen());
    }

    @Test
    public void handle() throws Exception {
        DoorHandler doorHandler = new DoorHandler();
        SmartHome home = new SmartHome();
        String doorId = "1";
        Door door = new Door(doorId,true);
        home.addRoom(new Room(Collections.emptyList(),
            Arrays.asList(door),
            "room"));
        SensorEvent event = new SensorEvent(SensorEventType.DOOR_CLOSED, doorId);
        doorHandler.handleEvent(event);
        event = new SensorEvent(SensorEventType.DOOR_OPEN, doorId);
        doorHandler.handleEvent(event);
        assertTrue(door.isOpen());
    }
}
