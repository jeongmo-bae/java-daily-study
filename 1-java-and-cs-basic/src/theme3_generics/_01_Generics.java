package theme3_generics;

public class _01_Generics {
    public static void main(String[] args) {
        Integer[] iArray = {1,2,3,4,5};
        Double[] dArray = {1.0,2.0,3.0,4.0,5.0};
        String[] sArray = {"a","b","c","d","e"};

        printAnyArray(iArray);
        printAnyArray(dArray);
        printAnyArray(sArray);
    }
    // Generics - 객체만 지원 - primitive 불가능
    // 타입 의존성을 없애준다?
    // T : Type / K : Key / V : Value / E : Element
    private static <T> void printAnyArray(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
