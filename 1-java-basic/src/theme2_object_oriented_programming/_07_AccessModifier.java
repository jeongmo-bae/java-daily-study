package theme2_object_oriented_programming;

public class _07_AccessModifier {
    public static void main(String[] args) {
        // 캡슐화(Encapsulation) - 연관된 것만 담는다.
        // 정보은닉(information hiding) - private int price - 허용하는 메서드로만 접근할 수 있게!

        //접근제어자
        //private 해당 클래스 내에서만 접근 가능
        //public 모든 클래스에서 접근 가능
        //default (아무것도 적지 않았을때) 같은 패키지 내에서만 접근가능
        //protected 같은 패키지 내에서는 접근가능, 다른 클래스라면 자식 패키지에서만 접근가능(상속한 클래스)
        BlackBoxRefurbish b1 = new BlackBoxRefurbish();
        String color = b1.getColor();
        b1.setPrice(55000);
        int price = b1.getPrice();
        String resol = b1.getResolution();
        System.out.println(color + " / " + price + " / " + resol );
        //b1.price = -5000;
        //System.out.println(b1.getPrice());
        // 접근이 됨 - private 을 붙이면?
        // 안 됨! - price has private access in theme2_object_oriented_programming.BlackBoxRefurbish
        // getter setter 로만 접근 가능해지는 거지
        b1.setPrice(-5000);
        System.out.println(b1.getPrice());
    }
}
