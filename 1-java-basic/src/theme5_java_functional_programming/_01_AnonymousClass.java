package theme5_java_functional_programming;

import java.util.ArrayList;

public class _01_AnonymousClass {
    public static void main(String[] args) {
        Coffee c1 = new Coffee();
        c1.order("아메리카노");
        c1.returnTray();
        System.out.println("=====================");
        // 익명 클래스
        Coffee specialCoffee  = new Coffee(){
            @Override
            public void order(String coffee) {
                super.order(coffee);
                System.out.println("(귓속말) 딸기케이크는 서비스에요");
            }

            @Override
            public void returnTray() {
                System.out.println(" (귓속말)내가 치울게");
            }
        };
        specialCoffee.order("바닐라라떼");
        specialCoffee.returnTray();
        //==============================================================/
        ArrayList<String> iList = new ArrayList<>();
        iList.add("빵");
        iList.add("햄");
        iList.add("치즈");
        Burger burger1 = getMomMadeBurger(iList);
        burger1.cook();
    }
    public static Burger getMomMadeBurger(ArrayList<String> ingredentsList){
        return new Burger(ingredentsList) {
            @Override
            public void cook() {
                System.out.println("엄마가 만들어주는 버거");
                System.out.println("Ingredients : " + this.ingredients);
            }
        };
    }
}
class Coffee{
    public void order(String coffee){
        System.out.println(coffee + " 나왔어요");
    }
    public void returnTray(){
        System.out.println("쟁반 반납이 완료되었습니다");
    }
}
abstract class Burger{
    ArrayList<String> ingredients;
    Burger(ArrayList<String> ingredients){
        this.ingredients=ingredients;
    }
    public abstract void cook();
}