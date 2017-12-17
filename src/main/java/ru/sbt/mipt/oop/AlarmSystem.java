package ru.sbt.mipt.oop;

import java.util.function.Function;

public class AlarmSystem implements AlarmSystemStateInterface, Functionable {


    private AlarmSystemStateInterface alarmSystemStateInterface;

    public AlarmSystem(){
        alarmSystemStateInterface = new AlarmSystemStateOff(this);
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return alarmSystemStateInterface.getState();
    }

    @Override
    public void turnOn() {
        alarmSystemStateInterface.turnOn();
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        alarmSystemStateInterface.onEvent(sensorEvent);
    }

    void setAlarmSystemState(AlarmSystemStateInterface alarmSystemStateInterface) {
        this.alarmSystemStateInterface = alarmSystemStateInterface;
    }

    @Override
    public void executeFunc(Function<Object, Void> function) {
        function.apply(this);
    }
}

