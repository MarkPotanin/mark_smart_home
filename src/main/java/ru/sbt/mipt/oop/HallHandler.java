package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HallHandler implements EventHandler {

    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == DOOR_CLOSED) {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
            DoorIterator doorIterator = (DoorIterator) ctx.getBean("doorIterator");
            SmartHome smartHome = (SmartHome) ctx.getBean("smartHome");
            doorIterator.handleFunction(door -> {
                if (door.getId().equals(event.getObjectId())) {
                    for (Room room :smartHome.getRooms()) {
                        if (room.getName().equals("hall")) {
                            if (room.getDoors().contains(door)) {
                                smartHome.executeFunc(object -> {
                                    if (object instanceof Light) {
                                        Light light = (Light) object;
                                        light.setOn(false);
                                        SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF,
                                            light.getId());
                                        Application.handleCommand(command);
                                    }
                                    return null;
                                });
                                return null;
                            } else {
                                return null;
                            }
                        }
                    }
                }
                return null;
            });
        }
    }
}
