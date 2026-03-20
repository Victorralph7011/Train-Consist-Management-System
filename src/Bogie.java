package com.train.management;

public class Bogie {
    String bogieId;
    String bogieType;

    public Bogie(String bogieId, String bogieType) {
        this.bogieId = bogieId;
        this.bogieType = bogieType;
    }

    @Override
    public String toString() {
        return "[" + bogieId + " : " + bogieType + "]";
    }
}