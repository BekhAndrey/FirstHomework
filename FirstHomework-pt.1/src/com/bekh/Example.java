package com.bekh;


public class Example {
    public void printText(){
        System.out.println("Hello from Example class!");
    }

    public Integer multiplyLocalClassText(Integer multiplier){
        class LocalExample{
            private Integer localClassNumber = 5;

            public Integer getLocalClassNumber(){
                return this.localClassNumber;
            }
        }
        return new LocalExample().getLocalClassNumber() * multiplier;
    }

    public class InnerExample{
        public void printInnerClassText(){
            System.out.println("Hello from InnerExample class!");
        }
    }

    public void printAnonymousText(){
        ExampleInterface exampleInterface = new ExampleInterface() {
            @Override
            public void printInterfaceText() {
                System.out.println("Hello from anonymous class!");
            }
        };
        exampleInterface.printInterfaceText();
    }
}

