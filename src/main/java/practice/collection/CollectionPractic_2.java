package practice.collection;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionPractic_2 {

    public static void main(String[] args) {

        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,6,4,7,4,8,5,657,789,2));

        collection.stream()
                .filter(i->i>100)
                .forEach(i-> {System.out.println(i+" " + i*i);});

        System.out.println(collection.stream()
                .filter(i->i>100).collect(Collectors.toList()));

        Set<Integer> resultSet= new TreeSet<>(collection);
       // resultSet.forEach(System.out::println);

    }

}
