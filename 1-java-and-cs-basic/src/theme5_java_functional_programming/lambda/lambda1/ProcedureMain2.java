package theme5_java_functional_programming.lambda.lambda1;

import theme5_java_functional_programming.lambda.Procedure;

public class ProcedureMain2 {
    public static void main(String[] args) {
        Procedure procedure = () -> {
                System.out.println("Hello lambda!");
        };
        procedure.run();
    }
}
