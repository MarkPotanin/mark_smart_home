package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DoorHandler implements EventHandler {
    @Override
    public void handleEvent(SensorEvent event) {
        if (event.getType() == DOOR_OPEN && event.getType() == DOOR_CLOSED) {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
            DoorIterator doorIterator = (DoorIterator) ctx.getBean("doorIterator");
            doorIterator.handleFunction(door -> {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                        SensorCommand command = new SensorCommand(CommandType.DOOR_OPEN,
                            door.getId());
                        Application.handleCommand(command);
                    } else {
                        door.setOpen(false);
                        SensorCommand command = new SensorCommand(CommandType.DOOR_CLOSED,
                            door.getId());
                        Application.handleCommand(command);
                    }
                }
                return null;
            });
        }
    }
}
