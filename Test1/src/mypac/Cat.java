package mypac;

public class Cat extends Animal {

    public void feed (String feed){
        System.out.println("I like " + feed);
    }

    @Override
    public void sound() {
        System.out.println("Mew");
    }
}
