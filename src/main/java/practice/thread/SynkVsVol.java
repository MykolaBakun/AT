package practice.thread;

import java.util.*;

public class SynkVsVol {
    int a;
    int getA() {return a;}

    volatile int b;
    int getB() {return b;}

    int c;
    synchronized int getC() {return c;}

    public static void main(String[] args) {
        //synchronizedCollection
        Collection<Integer> syncCollection = Collections.synchronizedCollection(new ArrayList<>());

        //synchronizedList
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());

        //synchronizedMap
        Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<>());

        //synchronizedSet
        Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());

//        XmlMapper xmlMapper = new XmlMapper();
//        Flower poppy = xmlMapper.readValue(xml, Flower.class);


    }



}
