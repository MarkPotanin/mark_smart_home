package ru.sbt.mipt.oop;


public class AlarmSystemStateOff implements AlarmSystemStateInterface {

  private final AlarmSystem alarmSystem;

  public AlarmSystemStateOff(AlarmSystem alarmSystem) {
    this.alarmSystem = alarmSystem;
  }

  @Override
  public AlarmSystemStateEnum getState() {
    return AlarmSystemStateEnum.OFF;
  }

  @Override
  public void turnOn() {
    alarmSystem.setAlarmSystemState(new AlarmSystemStateOn(alarmSystem));
  }

  @Override
  public void onEvent(SensorEvent sensorEvent) {
    if (sensorEvent.getType() == SensorEventType.ALARM_ON) turnOn();
  }
}
