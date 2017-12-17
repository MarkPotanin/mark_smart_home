package ru.sbt.mipt.oop.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.LightIterator;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;

public class LightIteratorTest {
    @Test
    public void Test() {
        SmartHome smartHome = new SmartHome();
        String lightId1 = "1";
        String lightId2 = "2";
        String lightId3 = "3";
        String lightId4 = "4";
        Light light1 = new Light(lightId1, false);
        Light light2 = new Light(lightId2, false);
        Light light3 = new Light(lightId3, false);
        Light light4 = new Light(lightId4, false);
        Room room = new Room(Arrays.asList(light1, light2, light3, light4),
            Collections.emptyList(),
            "hall");
        smartHome.addRoom(room);
        List<Object> objectList = new ArrayList<>();
        objectList.add(light1);
        objectList.add(light2);
        objectList.add(light3);
        objectList.add(light4);
        new LightIterator(smartHome).handleFunction(light -> {
            objectList.remove(light);
            return null;
        });
        assertEquals(0, objectList.size());
    }
}