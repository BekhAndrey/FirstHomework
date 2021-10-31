package com.bekh;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Integer, Integer> anonymousClass = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 5;
            }
        };
        System.out.println("Anonymous result: " + anonymousClass.apply(10));

        Function<Integer, Integer> lambdaExpression = x->x*5;
        System.out.println("Lambda result: " + lambdaExpression.apply(10));
    }
}
