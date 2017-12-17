package ru.sbt.mipt.oop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriterCSV {

    private final SmartHome smartHome;

    public WriterCSV(SmartHome smartHome)  {
        this.smartHome = smartHome;
    }

    public void write() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SmartHome\n");
        for (Room room: this.smartHome.getRooms()) {
            stringBuilder.append("Room,").append(room.getName()).append("\n");
            for (Light light: room.getLights()) {
                stringBuilder.append("Light,")
                    .append(light.getId())
                    .append(",")
                    .append(light.isOn())
                    .append("\n");
            }
            for (Door door: room.getDoors()) {
                stringBuilder.append("Door,")
                    .append(door.getId())
                    .append(",")
                    .append(door.isOpen())
                    .append("\n");
            }
            stringBuilder.append("RoomEnd\n");
        }
        if (smartHome.getAlarmSystem() != null) {
            stringBuilder.append("AlarmSystem,")
                .append(String.valueOf(smartHome.getAlarmSystem().getState()));
        }
        stringBuilder.append("SmartHome");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("smart-home.csv"))) {
            bufferedWriter.write(stringBuilder.toString());
        }
    }
}
