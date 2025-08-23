package theme5_java_functional_programming.lambda.lambda1;

import theme5_java_functional_programming.lambda.MyFunction;

public class MyFunction1 {
    public static void main(String[] args) {
        MyFunction myFunction = new MyFunction(){
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        };
        int result = myFunction.apply(1,2);
        System.out.println("result = " + result);
    }
}
