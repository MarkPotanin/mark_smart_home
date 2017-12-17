package ru.sbt.mipt.oop;

import java.util.Collection;
import java.util.function.Function;

public class Room implements Functionable{
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;


    public Room(Collection<Light> lights, Collection<Door> doors,
        String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void executeFunc(Function<Object, Void> function) {
        for (Light light: lights) {
            light.executeFunc(function);
        }
        for (Door door: doors) {
            door.executeFunc(function);
        }
        function.apply(this);
    }
}
