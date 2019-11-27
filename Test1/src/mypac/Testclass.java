/*package mypac;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Testclass {
    public static void main(String[] args) {

       /*String s = "hi";
        System.out.println(s.equals("hi"));
        System.out.println(s.equals("hello"));

        String s2 = "hihi";
        System.out.println(s.equals(s2));


        System.out.println();

        s = "TeXt";
        System.out.println(s.toLowerCase()); // все с маленькой буквы
        System.out.println(s.toUpperCase()); //все с большой буквы


        System.out.println();
        System.out.println(s.charAt(1));// выводит симовл с индексом 1
        System.out.println(s.indexOf("Xt"));// выводит индекс символа

        s = "Hi!";
        System.out.println(s.contains("Hi"))// содержит ли
        System.out.println(s.length()); // длина строки

        System.out.println();
        System.out.println(s.startsWith("H")); //начинается ли с такого
        System.out.println(s.startsWith("!")); // заканчивается ли таким
        System.out.println(s.endsWith()With("!"));

        s= "hello, world";
        System.out.println();
        String[] array = s.split (","); // разделяет элементы строки, запятая как разделитель


        System.out.println(array[0] + "!" + array[1] + "!");

        System.out.println();

        String str = "My name is %s! I'm %d years old.";
        int age = 30;
        String name = "Ivan";
        System.out.println(String.format(str, name, age)); //подтсановка значений

        String age2 = "30";
        int a = Integer.parseInt(age2); // реобразование текста в число
        System.out.println(a*3);

        String s = "Hi, World";

        System.out.println(s.substring(1, 5));
        System.out.println(s.substring(4));
        System.out.println(s.substring(4, s.length() - 1));

        String s1="Hello ";
        String s2 = "World";
        String s3 = "!";
        String res = s1 + s2 + s3;
        System.out.println(res);
        res = s1.concat(s2);
        System.out.println(res); */

//УСЛОВНЫЕ ОПЕРАТОРЫ
   /*  int i = 3;
     System.out.println("start");
     if (i>6)
     {
      System.out.println("i>6");
     }
     else if (i<4 && i>2){
      System.out.println("i<4");
     }
     else {
      System.out.println("Nothing");
     }
     System.out.println("end");

     System.out.println();

     i = 85;

     if (i>50){
      System.out.println("i>50");
      if(i>90){
       System.out.println("i>90");
      }
      else{
       System.out.println("i<90");}
     }
     else {
      System.out.println("i<=50");
     }

     i = 5;
     switch (i){
      case 1:
       System.out.println("Then number is 1");
       break;
      case 2:
       System.out.println("Then number is 2");
       break;
      case 3:
       System.out.println("Then number is 3");
       break;
      default:
       System.out.println("I don't nknow the number");
     }

//ЦИКЛЫ
         for (int i=0; i<5; i++){
          System.out.println(i*10);
         }


     System.out.println();

     for (int i=10; i>0; i--){
      System.out.println(i);
     }
     System.out.println();
     int[] array = new int [10];
     for (int i =0; i<10; i++){
      array[i]=i*2;
     }
     for (int i =0; i<10; i++){
      System.out.println("Element with index " + i + " is: " + array[i]);
     }

     for(int element : array) {
      System.out.println(element);
     }
     System.out.println();
     int i=0;
     boolean bool = true;
     while (bool) {
      System.out.println("while: " + i);
      i++;
      if (i==5) bool = false;
     }

     System.out.println();

     i=5;
     do{
      System.out.println("Do " +i);
      i++;
     } while (i<5);


     int [] array = new int [3]; // задание массива

        List<Integer> list = new ArrayList<>();

        list.add(5); //добавление элемента
        list.add(10);
        list.add(9);

     System.out.println(list.get(1)); // получение элемента
     System.out.println(list.get(0));


     list.set(2, 100); //установление нового значения элементу
     System.out.println(list.get(2));


     System.out.println(list.get(1));
     list.remove(1);// удаление элемента
     System.out.println(list.get(1));

     System.out.println();
     System.out.println(list.size());// размер списка

     list.add(10);
     System.out.println(list.size());

     System.out.println();

     //list.clear(); //очистка списка
    // System.out.println(list.size());


     List<Integer> list2 = new ArrayList<>();

     list2.add(45);
     list2.add(56);

     System.out.println();
     System.out.println(list.size());
     list.addAll(list2); // добавить жлементы второго списка в первый список
     System.out.println(list.size());

     list.removeAll(list2); //удалить элементы второго списка из первого списка
     System.out.println(list.size());

     System.out.println(list.isEmpty());
     //list.clear();
     System.out.println(list.isEmpty());


     System.out.println(list.contains(5));

        Iterator<Integer> iterator = list.iterator();
       // System.out.println(iterator.next());
      //  System.out.println(iterator.next());
       // System.out.println(iterator.hasNext());

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
ggg */