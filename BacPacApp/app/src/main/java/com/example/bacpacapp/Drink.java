package com.example.bacpacapp;

class Drink {
        String name;
        static double AlContent;
        static double volume=12;
        Drink(String name,double AlContent){
            this.name=name;
            this.AlContent=AlContent;
        }
        static double getVolume(){
            return volume;
        }
        static double getAlContent(){
            return AlContent;
        }

}
