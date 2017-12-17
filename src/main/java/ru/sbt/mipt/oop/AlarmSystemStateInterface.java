package ru.sbt.mipt.oop;


public interface AlarmSystemStateInterface {

    AlarmSystemStateEnum getState();

    void turnOn();

    void onEvent(SensorEvent sensorEvent);

}
