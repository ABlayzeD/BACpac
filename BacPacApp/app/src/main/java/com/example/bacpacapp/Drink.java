package com.example.bacpacapp;

class Drink {
        String name;
        static float AlContent;
        static float volume=12;
        Drink(String name,float AlContent){
            this.name=name;
            this.AlContent=AlContent;
        }
        static float getVolume(){
            return volume;
        }
        static float getAlContent(){
            return AlContent;
        }

}
