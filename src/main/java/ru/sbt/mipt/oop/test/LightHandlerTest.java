package ru.sbt.mipt.oop.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.LightHandler;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.SmartHome;

public class LightHandlerTest {
    @Test
    public void test1() throws Exception {
        LightHandler lightHandler = new LightHandler();
            SmartHome home = new SmartHome();
        String lightId = "1";
        Light light = new Light(lightId, false);
        home.addRoom(new Room(Arrays.asList(light),
                Collections.emptyList(),
            "room"));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_OFF, lightId);
        lightHandler.handleEvent(event);
        event = new SensorEvent(SensorEventType.LIGHT_ON, lightId);
        lightHandler.handleEvent(event);
        assertTrue(light.isOn());
    }

    @Test
    public void test2() throws Exception {
        LightHandler lightHandler = new LightHandler();
        SmartHome home = new SmartHome();
        String lightId = "1";
        Light light = new Light(lightId, true);
        home.addRoom(new Room(Arrays.asList(light),
            Collections.emptyList(),
            "room"));
        SensorEvent event = new SensorEvent(SensorEventType.LIGHT_ON, lightId);
        lightHandler.handleEvent(event);
        event = new SensorEvent(SensorEventType.LIGHT_OFF, lightId);
        lightHandler.handleEvent(event);
        assertFalse(light.isOn());

    }

}