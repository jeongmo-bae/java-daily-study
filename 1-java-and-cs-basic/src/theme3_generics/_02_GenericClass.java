package theme3_generics;

import theme3_generics.coffee.CoffeeByAny;
import theme3_generics.coffee.CoffeeByName;
import theme3_generics.coffee.CoffeeByNickname;
import theme3_generics.coffee.CoffeeByNumber;

public class _02_GenericClass {
    public static void main(String[] args) {
        // 제네릭 클래스
        CoffeeByNumber c1 = new CoffeeByNumber(33);
        c1.ready();

        CoffeeByNickname c2 = new CoffeeByNickname("유재석님");
        c2.ready();
        System.out.println("========================");
        CoffeeByName c3 = new CoffeeByName(34);
        c3.ready();
        CoffeeByName c4 = new CoffeeByName("박명수");
        c4.ready();
        System.out.println("========================");
        int c3Name = (int) c3.name;
        System.out.println("주문 고객 번호 : "+ c3Name);
        String c4Name = (String) c4.name;
        System.out.println("주문 고객 이름 : "+c4Name);
        System.out.println("========================");
        CoffeeByAny<Integer> cInteger = new CoffeeByAny<>(35);
        cInteger.ready();
        CoffeeByAny<String> cString = new CoffeeByAny<>("조세호");
        cString.ready();
        System.out.println("========================");
        int cIntegerName = cInteger.name;
        System.out.println(cIntegerName);
        
    }
}
