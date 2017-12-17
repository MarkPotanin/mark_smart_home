package ru.sbt.mipt.oop.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import ru.sbt.mipt.oop.AlarmSystem;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;


public class ComposeTest {

    @Test
    public void Test(){
        SmartHome smartHome = new SmartHome();
        String lightId = "1";
        String doorId = "2";
        Light light = new Light(lightId, false);
        Door door = new Door(doorId, false);
        AlarmSystem alarmSystem = new AlarmSystem();
        Room room = new Room(Arrays.asList(light),
            Arrays.asList(door),
            "hall");
        smartHome.setAlarmSystem(alarmSystem);
        smartHome.addRoom(room);
        List<Object> objectList = new ArrayList<>();
        objectList.add(smartHome);
        objectList.add(alarmSystem);
        objectList.add(room);
        objectList.add(door);
        objectList.add(light);
        smartHome.executeFunc(o -> {
            objectList.remove(o);
            return null;
        });
        assertEquals(0, objectList.size());
    }
}