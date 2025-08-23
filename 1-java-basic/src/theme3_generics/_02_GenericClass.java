package theme3_generics;

import theme3_generics.coffee.*;
import theme3_generics.user.User;
import theme3_generics.user.VIPUser;

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
        System.out.println("========================");
        CoffeeByUser<VIPUser> cVIP = new CoffeeByUser<>(new VIPUser("배정모"));
        cVIP.ready();
        System.out.println("========================");
        orderCoffee("qowjdah");
        System.out.println("========================");
        CoffeeOrder<Integer , String> test = orderCoffee(37,"라떼");
        System.out.println(test.getClass());
        System.out.println(test.getName() + " 님 " + test.getCoffee() + " 주문 완료되었습니다.");
    }
    public static <T>  void orderCoffee(T name){
        System.out.println("커피 준비 완요 : "  + name);
    }
    public static <T,U>  CoffeeOrder<T,U> orderCoffee(T name, U coffee){
        return new CoffeeOrder<>(name,coffee);
    }
}
