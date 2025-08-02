package theme1_java_basic;

public class _13_MethodOverloading {
    public static int powerByExp(int num, int exponent){
        int result = 1;
        for(int i=0; i<exponent;i++ ){
            result *= num;
        }
        return result;
    }
    //method overloading : parameter 의 자료형이 다르거나, 개수가 다르면 overloading 가능. return 이 다른건 불가능!!
    public static int powerByExp(String strNum, String strExponent) {
        int num = Integer.parseInt(strNum);
        int exponent = Integer.parseInt(strExponent);
        int result = 1;
        for(int i=0; i<exponent;i++ ){
            result *= num;
        }
        return result;
    }
    public static int powerByExp(int num) {
        return powerByExp(num,2);
    }
    public static void main(String[] args) {
        String strNum1 = "12";
        String strNum2 = "3";
        int result = powerByExp(strNum1,strNum2);
        System.out.printf("\n%s exponential %s is %d",strNum1,strNum2,result);
        System.out.printf("\noverloading test : %d",powerByExp(9));
    }
}
