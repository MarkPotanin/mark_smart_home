package ru.sbt.mipt.oop.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import ru.sbt.mipt.oop.AlarmSystemSensor;
import ru.sbt.mipt.oop.DoorHandler;
import ru.sbt.mipt.oop.LightHandler;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventObserver;
import ru.sbt.mipt.oop.SmartHome;

public class SensorEventObserverTest {
    @Test
    public void test() {
        SmartHome smartHome = mock(SmartHome.class);
        LightHandler lightHandler = mock(LightHandler.class);
        DoorHandler doorHandler = mock(DoorHandler.class);
        AlarmSystemSensor alarmSystemSensor = mock(AlarmSystemSensor.class);


        SensorEventObserver sensorEventObserver = new SensorEventObserver(smartHome);
        SensorEvent sensorEvent = mock(SensorEvent.class);
        sensorEventObserver.handleEvent(sensorEvent);

        verify(lightHandler).handleEvent(sensorEvent);
        verify(doorHandler).handleEvent(sensorEvent);
        verify(alarmSystemSensor).handleEvent(sensorEvent);
    }
}