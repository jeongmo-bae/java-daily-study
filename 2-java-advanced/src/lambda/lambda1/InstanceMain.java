package lambda.lambda1;

import lambda.Procedure;

public class InstanceMain {
    public static void main(String[] args) {
        Procedure procedure1 = new Procedure() {
            @Override
            public void run(){
                System.out.println("\n=========InstanceMainOfLambda1==========");
            }
        };
        procedure1.run();
        System.out.println("class.class = " + procedure1.getClass());
        System.out.println("class.instance = " + procedure1);
        
        Procedure procedure2 = () -> {
            System.out.println("\n=========InstanceMainOfLambda2==========");
        };
        procedure2.run();
        System.out.println("lambda.class = " + procedure2.getClass());
        System.out.println("lambda.instance = " + procedure2);
        
    }
}

// =========InstanceMainOfLambda1==========
// class.class = class theme5_java_functional_programming.lambda.lambda1.InstanceMain$1
// class.instance = theme5_java_functional_programming.lambda.lambda1.InstanceMain$1@16b4a017

// =========InstanceMainOfLambda2==========
// lambda.class = class theme5_java_functional_programming.lambda.lambda1.InstanceMain$ $Lambda$1/0x0000000800063c40
// lambda.instance = theme5_java_functional_programming.lambda.lambda1.InstanceMain$ $Lambda$1/0x0000000800063c40 @6842775d