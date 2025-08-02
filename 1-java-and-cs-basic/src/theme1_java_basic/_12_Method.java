package theme1_java_basic;

public class _12_Method {
    public static void printMessege(String name) {
        System.out.printf("Your name is %s",name);
    }
    public static int getSquaredValue(int num) {
        int squaredValue;
        squaredValue = num * num;
        return squaredValue;
    }
    public static int powerByExp(int num, int exponent){
        int result = 1;
        for(int i=0; i<exponent;i++ ){
            result *= num;
        }
        return result;
    }
    public static void main(String[] args) {
        String name = "Jungmo";
        int num1 = 462;
        int num2 = 3;
        int num3 = 8;
        printMessege(name);
        System.out.printf("\nSquare value of %d is %d",num1,getSquaredValue(num1));
        System.out.printf("\n%d exponential %d is %d",num2,num3,powerByExp(num2,num3));
    }
}
