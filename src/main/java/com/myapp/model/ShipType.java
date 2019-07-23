package com.myapp.model;

public enum ShipType {

    CARRIER(5, "carrier"),
    BATTLESHIP(4, "battleship"),
    CRUISER(3, "cruiser"),
    SUBMARINE(3, "submarine"),
    DESTROYER(2, "destroyer");

    private int size;

    private String name;

    ShipType(int size, String name) {
        this.size = size;
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }
}
