package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class LightIterator implements Iterator<Light>, IteratorFunction<Light> {

    private List<Room> roomList;
    private int roomPosition;
    private int lightPosition;

    public LightIterator(SmartHome smartHome) {
        roomList = new ArrayList<>(smartHome.getRooms());
    }

    @Override
    public boolean hasNext() {
        if (roomPosition <= roomList.size() - 1) {
            if (lightPosition <= roomList.get(roomPosition).getLights().size() - 1) {
                return true;
            } else {
                roomPosition++;
                lightPosition = 0;
                return hasNext();
            }
        }
        return false;
    }

    @Override
    public Light next() {
        if (hasNext()) {
            List<Light> lightList = new ArrayList<>(roomList.get(roomPosition).getLights());
            Light light = lightList.get(lightPosition);
            lightPosition++;
            return light;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public void handleFunction(Function<Light, Void> func) {
        while(hasNext()) {
            Light light = next();
            func.apply(light);
        }
    }
}
