package Model.singleton;

import Model.coffees.Coffee;

public class Barista {
    private static Barista instance = null;
    private final String name;

    private Barista(String name){
        this.name = name;
    }

    public static Barista getInstance() {
        if (instance == null)
            instance = new Barista("Tim");
        return instance;
    }
    public String getName(){return this.name;}

    public void makeCoffee(Coffee coffee) {
        System.out.println("currently preparing your " + coffee.getTitle());
    }
}