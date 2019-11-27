package mypac;

public class AbstractDog extends Anim{
    @Override
    public void saySmth() {
        System.out.println("Gav");
    }

    @Override
    public void eat() {
        System.out.println("Green");

    }

    public void sit() {
        System.out.println("I'm sitting");
    }
}
