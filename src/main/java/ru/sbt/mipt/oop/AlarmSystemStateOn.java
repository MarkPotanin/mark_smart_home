package ru.sbt.mipt.oop;


public class AlarmSystemStateOn implements AlarmSystemStateInterface {

    private final AlarmSystem alarmSystem;

    public AlarmSystemStateOn(AlarmSystem alarmSystem) {
        this.alarmSystem = alarmSystem;
    }

    @Override
    public AlarmSystemStateEnum getState() {
        return AlarmSystemStateEnum.ON;
    }

    @Override
    public void turnOn() {
        alarmSystem.setAlarmSystemState(new AlarmSystemStatePassword(alarmSystem));
    }

    @Override
    public void onEvent(SensorEvent sensorEvent) {
        if ( sensorEvent.getType() == SensorEventType.ALARM_ALARM) {
            alarmSystem.setAlarmSystemState(new AlarmSystemStateAlarm(alarmSystem));
        }
        else turnOn();
    }
}
