package practice.oop;

import java.util.*;

public class OOP {

    public static void main(String[] args) {
        Integer[] arr= new Integer[10];
        List<Human> humanList= new ArrayList<>();


        humanList.add(new YoungHuman(1,"sdfsdf"));
        humanList.add(new YoungHuman());

        humanList.get(0);
       // humanList.add(new Animal());
        List<Animal> animalList;
        List<Etable>  etableList=new ArrayList<>();
        etableList.add(new Animal());
        etableList.addAll(humanList);
        etableList.get(0).eat("sdfsdf");

    }
}
