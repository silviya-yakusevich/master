package mypac;

public class Car {

    /*public Car(){
        System.out.println("New car created");
    }

    public Car(String color){
        this.color = color;
    }



    public Car(String color, int height, int width, int length){
        this.color = color;
        this.height = height;
        this.width = width;
        this.length = length;
    }*/

   final static int var = 10; // final означает что больше нигде не смодем изменять
    static void method () {
        System.out.println("Static method");
    }

    int height;
    int width;
    int length;
    int weight = 2000;
    int maxWeight = 2700;
    String color;
    int speed;
    int maxSpeed = 260;

    public void addWeight (int weight){
        this.weight += weight; //к текущей массе автомобиля добавляем ту массу, которую указали при вызове метода
        System.out.println("New weight: " + this.weight);
    }
    public void drive (int speed){
        if (weight<=maxWeight) {
            this.speed = speed;
            System.out.println("Go!");
        }
        else{
            System.out.println("Cannot drive!");
        }
    }
    }

