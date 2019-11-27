package mypac;

public abstract class Anim {

    public abstract void saySmth();
    public abstract void eat();

    public void walk(String place){

        System.out.println("Go!" + place);
    }
}
