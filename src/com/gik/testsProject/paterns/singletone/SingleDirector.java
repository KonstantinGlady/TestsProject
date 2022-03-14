package com.gik.testsProject.paterns.singletone;

public class SingleDirector {

    private static Director instance;

    private SingleDirector() {
    }

    public static Director getInstance() {
        if (instance == null) {
            synchronized (Director.class) { // in case we need threadsafe singleton, we put it in synchronized
                instance = new Director();
            }
        }
        return instance;
    }
}
