package com.bekh;

public class Main {

    public static void main(String[] args) {
        Example example = new Example();
        example.printText();
        Example.InnerExample innerExample = new Example().new InnerExample();
        innerExample.printInnerClassText();
        System.out.println("multiplyLocalClassText result: " + example.multiplyLocalClassText(3));
        example.printAnonymousText();
    }
}
