package ru.sbt.mipt.oop.test;

import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import org.junit.Test;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.HallHandler;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;

public class DoorHallHandlerTest {
    @Test
    public void handle() throws Exception {
        HallHandler hallHandler = new HallHandler();
        SmartHome home = new SmartHome();
        String lightId1 = "1";
        String lightId2 = "2";
        String doorId = "4";
        Light light1 = new Light(lightId1, true);
        Light light2 = new Light(lightId2, true);
        Door door = new Door(doorId, false);
        home.addRoom(new Room(Arrays.asList(light1, light2),
                Arrays.asList(door),
            "hall"));
        hallHandler.handleEvent(new SensorEvent(SensorEventType.DOOR_CLOSED, doorId));
        assertFalse(light1.isOn());
        assertFalse(light2.isOn());
    }
}