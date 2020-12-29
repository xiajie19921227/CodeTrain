package com.dataStructure.linkedList;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put(1,"aa");
        linkedHashMap.put(2,"bb");
        linkedHashMap.put(3,"cc");


//        while (iterator.hasNext()){
//            Map.Entry<Integer, String> next = iterator.next();
//            System.out.println(next.getKey() + " "+next.getValue());
//        }
      //  linkedHashMap.get(2);
        Iterator<Map.Entry<Integer, String>> iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + " "+next.getValue());
        }
    }
}
