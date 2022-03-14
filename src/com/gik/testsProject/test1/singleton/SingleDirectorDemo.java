package com.gik.testsProject.test1.singleton;

public class SingleDirectorDemo {
    public static void main(String[] args) {

        Director director = SingleDirector.getInstance();

        System.out.println(director);
    }
}

class Director {
    String name;
    int id;

    Director(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "name " + name + " id " + id;
    }
}

class SingleDirector {
    private static Director instance;

    private SingleDirector() {
    }

    public static Director getInstance() {
        if (instance == null) {
            synchronized (Director.class) {
                if (instance == null) {
                    instance = new Director("Tom", 11);
                }
            }
        }
        return instance;
    }
}



