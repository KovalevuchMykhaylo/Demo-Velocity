package com;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainExample {

    public static void main(String[] args) {

        Integer integer = 127;

        Integer newInteger = 127;

        System.out.println(integer == newInteger); //true


        Integer integer2 = 128;

        Integer newInteger2 = 128;

        System.out.println(integer2 == newInteger2); //false

        // create random object
        Random randomno = new Random();

        // check next int value
        System.out.println("Next int value: " + randomno.nextInt(1)); //always 0 bound must be positive

        Set<Integer> integers = new HashSet<>();
        integers.add(10);
        Set<Double> doubles = new HashSet<>();
        doubles.add(10.10);
        Set<Number> numbers = union(integers,doubles);
        numbers.forEach(System.out::println);

    }

    static <E> Set<E> union(Set<? extends E> set1, Set<? extends E> set2){
        Set<E> newSetUnionHashSet =  new HashSet<>(set1);
        newSetUnionHashSet.addAll(set2);
        return newSetUnionHashSet;
    }
}
