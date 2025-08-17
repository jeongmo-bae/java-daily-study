package theme5_java_functional_programming.lambda.lambda1;

import theme5_java_functional_programming.lambda.Procedure;

public class ProcedureMain1 {
    public static void main(String[] args) {
        Procedure procedure = new Procedure() {
            @Override
            public void run() {
                System.out.println("Hello lambda!");
            }
        };
        procedure.run();
    }
}
