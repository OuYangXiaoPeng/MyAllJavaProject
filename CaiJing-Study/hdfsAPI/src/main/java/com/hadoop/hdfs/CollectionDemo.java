package com.hadoop.hdfs;

import java.util.*;

/**
 *
 */
public class CollectionDemo {

    public static void main(String[] args) {
        //HashSet
        Set<String> sets = new HashSet<>();
        sets.add("a");
        sets.add("b");
        sets.add("c");
//        System.out.println(sets);
//        for (String s : sets) {
//            System.out.println(s);
//        }
        Iterator<String> it = sets.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }


        //定义一个ArrayList集合
        List<String> lists = new ArrayList<String>();
        lists.add("A");
        lists.add("B");
        lists.add("C");
        System.out.println(lists);
        for (String s : lists) {
            System.out.println(s);
        }
    }
}
