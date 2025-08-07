package testPackage;

//import theme2_object_oriented_programming.A;
import theme2_object_oriented_programming.BlackBoxRefurbish;

public class _01_AccessModifierTest {
    public static void main(String[] args) {
        BlackBoxRefurbish b1 = new BlackBoxRefurbish();
        b1.modelName = "MX";    // public - 접근가능
//        b1.resolution = "FHD";  // default - 접근불가 - 같은 패키지 내에서만 접근 가능
//        b1.price = 200000;   // private - 접근불가 - 같은 클래스 내에서만 접근 가능
//        b1.color = "black"; // protected - 접근불가 - 같은 패키지 or 타 패키지면 자식 클래스만

//        A a = new A();    // default class 로 선언해서 안되는거야
    }
}
