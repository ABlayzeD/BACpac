package com.example.bacpacapp;

class Drink {
    String name;
    float AlContent;
    static float volume = 12;

    Drink(String name, String AlContent) {
        this.name = name;
        this.AlContent = Float.parseFloat(AlContent);
    }

    static float getVolume() {
        return volume;
    }
}
