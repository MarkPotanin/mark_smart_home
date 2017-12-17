package ru.sbt.mipt.oop;


import java.util.function.Function;

public interface IteratorFunction<T> {
    public void handleFunction(Function<T, Void> func);
}
