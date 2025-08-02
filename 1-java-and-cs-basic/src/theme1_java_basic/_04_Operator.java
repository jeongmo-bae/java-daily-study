package theme1_java_basic;

public class _04_Operator {
    public static void main(String[] args) {
        unaryIncDecOperator();
        logicalOperator();
        ternaryOperator();
    }
    public static void unaryIncDecOperator() {
        System.out.printf("### unaryIncDecOperator ###");
        int val = 10;
        System.out.printf("\ninit val : %d",val);
        System.out.printf("\nprint val++ : %d",val++);
        System.out.printf("\nprint val : %d",val);
        System.out.printf("\nprint ++val : %d",++val);
    }
    public static void logicalOperator() {
        System.out.printf("\n### logicalOperator ###");
        boolean bool1 = true;
        boolean bool2 = false;
        System.out.printf("\nbool1 or bool2 : %b", bool1 || bool2);
        System.out.printf("\nbool1 and bool2 : %b",bool1 && bool2);
        System.out.printf("\nbool1 and not bool2 : %b",bool1 && !bool2);
     }
    public static void ternaryOperator() {
        System.out.printf("\n### ternaryOperator ###");
        int x = 5;
        int y = 4;
        int max = ( x > y ) ? x : y;
        int min = !( x > y ) ? x : y;
        boolean isSame = ( x == ++y ) ? true : false;
        System.out.printf("\nmax : %d", max);
        System.out.printf("\nmin : %d", min);
        System.out.printf("\nx = y : %b", isSame);
    }
}
