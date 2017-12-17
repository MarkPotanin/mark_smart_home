package ru.sbt.mipt.oop;


public class AlarmSystemStatePassword implements AlarmSystemStateInterface {

  private final AlarmSystem alarmSystem;


  public AlarmSystemStatePassword(AlarmSystem alarmSystem) {
    this.alarmSystem = alarmSystem;
  }

  @Override
  public AlarmSystemStateEnum getState() {
    return AlarmSystemStateEnum.WAIT_FOR_PASSWORD;
  }

  @Override
  public void turnOn() {
  }

  @Override
  public void onEvent(SensorEvent sensorEvent) {
    if (sensorEvent.getType() == SensorEventType.PASSWORD_SET) {
      alarmSystem.setAlarmSystemState(new AlarmSystemStateOff(alarmSystem));
    }
  }
}
