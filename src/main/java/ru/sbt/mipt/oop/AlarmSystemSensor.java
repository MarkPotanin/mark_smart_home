package ru.sbt.mipt.oop;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AlarmSystemSensor implements EventHandler{

    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == SensorEventType.ALARM_ON || event.getType() == SensorEventType.ALARM_OFF ||
            event.getType() == SensorEventType.ALARM_ALARM || event.getType() == SensorEventType.PASSWORD_SET) {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
            SmartHome smartHome = (SmartHome) ctx.getBean("smartHome");
            AlarmSystem alarmSystem = smartHome.getAlarmSystem();
            if (alarmSystem != null) {
                alarmSystem.onEvent(event);
            }
        }
    }
}
