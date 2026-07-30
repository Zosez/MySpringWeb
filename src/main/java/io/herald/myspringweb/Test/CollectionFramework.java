package io.herald.myspringweb.Test;

import java.util.*;

public class CollectionFramework {
    public static void main(String[] args) {

        List<Integer> intList = new Vector<>();


        Set<Integer> intSet = new TreeSet<>();

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"apple");
        map.put(2,"pineapple");

        System.out.println(map);

    }
}
