package ru.sbt.mipt.oop;

import java.util.function.Function;

public interface Functionable {
    public void executeFunc(Function<Object, Void> function);
}
