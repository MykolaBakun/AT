package practice.reflection;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        Animal animal= new Animal();
        animal.setAge(1);
        animal.setName("qwre");

        System.out.println(animal);

        Class claz = animal.getClass();

        for (Field f:claz.getDeclaredFields()){
            System.out.println(f);
            if(f.getName().equals("age")){
                f.setAccessible(true);
                try {
                    f.set(animal,2);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(animal);

//        for (Method m:claz.getDeclaredMethods()){
//            System.out.println(m);
//        }
//
//        for (Constructor c:claz.getDeclaredConstructors()){
//            System.out.println(c);
//        }
    }
}
