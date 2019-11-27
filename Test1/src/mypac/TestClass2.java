package mypac;

public class TestClass2 {
    public static void main(String[] args) {


       /* Car car1 = new Car();
        car1.color = "Black";
        car1.length = 5000;
        car1.height = 2000;
        car1.width = 2000;

        car1.addWeight(50);
        car1.drive(50);


        car1.addWeight(700);
        car1.drive(100);


        Car car2 = new Car();
        Car car3 = new Car();

        car2.drive(50);
        car3.drive(150);

        Car car4 = new Car("Blue");
        System.out.println("Car color is " + car4.color);

        Car car5 = new Car("Red", 2100, 2000, 5100);
        System.out.println(car5.color +  " " + car5.height +  " " + car5. width +  " " + car5.length);

        System.out.println(Car.var);
        Car.var=100;

        System.out.println(car1.var);
        System.out.println(car2.var);
        System.out.println(car3.var);

        Car.method();

        String.format ("New %s string", "string");*/

        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.name = "Money";
        dog.name = "Bobik";
        cat.color = "Black";
        dog.color = "White";
        cat.walk ("Backyard");
        dog.walk ("Park");

        cat.feed("Milk");
        dog.sit();

        System.out.println("Cat name is " + cat.name);
        System.out.println("Dog name is " + dog.name);

        dog.var = 10;
        System.out.println(dog.getWeight());


        dog.sound();
        cat.sound();

    }
}
