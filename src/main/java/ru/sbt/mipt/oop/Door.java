package ru.sbt.mipt.oop;

import java.util.function.Function;

public class Door implements Functionable{
    private final String id;
    private boolean isOpen;

    public Door(String id, boolean isOpen) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isOpen() { return isOpen; }

    @Override
    public void executeFunc(Function<Object, Void> function) {
        function.apply(this);
    }
}
