# 2025-08-03 TIL

## Instance Variable
```java
public class BlackBox {
    String modelName;
    String resolution;
    int price;
    String color;
}
```
## Class Variable
- 해당 클래스의 객체에 공통 적용
- 접근시 Class.Variable 로 접근 권장
- static 으로 선언
- 근데 이게, 객체 전부에 적용되다 보니, 리스크가 있어!! 그래서 절대 바뀌면 안되는건 final로 상수처리!!
```java
// theme2_object_oriented_programming.BlackBox
public class BlackBox {
    // class variable
    static boolean canAutoReport = false;
}
// theme2_object_oriented_programming._01_Class
public class _01_Class {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.modelName = "b1";
        b1.color = "Black";
        b1.price = 200000;
        b1.resolution="FHD";
        BlackBox b2 = new BlackBox();
        b2.modelName = "mx-master";

        // class variable test
        System.out.println("---자동 신고 기능 개발 전---");
        System.out.println(b1.modelName + " 자동 신고 기능 : " + b1.canAutoReport );
        System.out.println(b2.modelName + " 자동 신고 기능 : " + b2.canAutoReport );
        System.out.println("모든 블랙박스 제품의 자동 신고 기능 : " + BlackBox.canAutoReport);

        BlackBox.canAutoReport = true;

        System.out.println("---자동 신고 기능 개발 후---");
        System.out.println(b1.modelName + " 자동 신고 기능 : " + b1.canAutoReport );
        System.out.println(b2.modelName + " 자동 신고 기능 : " + b2.canAutoReport );
        System.out.println("모든 블랙박스 제품의 자동 신고 기능 : " + BlackBox.canAutoReport);
        
        b1.callServiceCenter();
        b2.callServiceCenter();
    }
}
```
## Class Method
- Class Variable 처럼 static 으로 정의
- static method 내에서 Instance Variable은 직접 접근 안돼.
- java: non-static variable modelName cannot be referenced from a static context
- Instance Variable 은 객체가 만들어져야 생기는 값이라 그래  
- Instance Variable 사용할 필요 없으면서 공통적용 사항일 때 사용 고려
- String.valueOf(i) 생각하면 돼 / Class.Method 로 바로 접근!
- Class Variable 은 접근 가능
```java
// theme2_object_oriented_programming.BlackBox
public class BlackBox {
    static void callServiceCenter() {
        System.out.println("서비스 센터로 연결합니다");
        //modelName = "TEST"; java: non-static variable modelName cannot be referenced from a static context
    }
}
```
## This
- python 에서 self 와 같음!!!
```java
public class BlackBox {
    // This
    void  appendModelName(String modelName) {
        this.modelName += modelName;
    }
}
```
## Constructor
- python Class 정의시 __init__() 메서드와 같다!!
- overloading 시 다른 생성자를 호출할 땐, 꼭 첫 줄에 this(args) 로!!! 
```python
Class Test:
    __init__(self,df):
        self.data = df
```
```java
public class BlackBox {
    // instance variable
    String modelName;
    String resolution;
    int price;
    String color;
    int serialNo;

    //Class Variable
    static int counter = 0; // serialNo 계산을 위해 쓰일 값
    static boolean canAutoReport = false; // class variable

    //Constructor
    BlackBox() {
        this.serialNo = ++counter; 
        System.out.println("Constructor setting is complete : serialNO=" + this.serialNo);
    }

    BlackBox(String modelName, String resolution, int price, String color) {
        this();
        this.modelName = modelName;
        this.resolution = resolution;
        this.price = price;
        this.color = color;
    }
}
```

## AccessModifier
- private : 해당 클래스 내에서만 접근 가능
- public : 모든 클래스에서 접근 가능
- default : (아무것도 적지 않았을때) 같은 패키지 내에서만 접근가능
- protected : 같은 패키지 내에서는 접근가능, 다른 클래스라면 자식 패키지에서만 접근가능(상속한 클래스)
- 캡슐화(Encapsulation) : 연관된 것만 담는다.
- 정보은닉(information hiding) : private int price - 허용하는 메서드로만 접근할 수 있게!

```java
// theme2_object_oriented_programming.BlackBoxRefurbish
public class BlackBoxRefurbish {
    public String modelName;    // public
    String resolution;  // default
    private int price;  // private
    String color;   // protected
}
// theme2_object_oriented_programming._07_AccessModifier
public class _07_AccessModifier {
    public static void main(String[] args) {
        BlackBoxRefurbish b1 = new BlackBoxRefurbish();
        String color = b1.getColor();
        b1.setPrice(55000);
        int price = b1.getPrice();
        String resol = b1.getResolution();
        System.out.println(color + " / " + price + " / " + resol);
        //b1.price = -5000;
        //System.out.println(b1.getPrice());
        // 접근이 됨 - private 을 붙이면?
        // 안 됨! - price has private access in theme2_object_oriented_programming.BlackBoxRefurbish
        // getter setter 로만 접근 가능해지는 거지
        b1.setPrice(-5000);
        System.out.println(b1.getPrice());
    }
}
// testPackage._01_AccessModifierTest
import theme2_object_oriented_programming.BlackBoxRefurbish;

public class _01_AccessModifierTest {
    public static void main(String[] args) {
        BlackBoxRefurbish b1 = new BlackBoxRefurbish();
        b1.modelName = "MX";    // public - 접근가능
//        b1.resolution = "FHD";  // default - 접근불가 - 같은 패키지 내에서만 접근 가능
//        b1.price = 200000;   // private - 접근불가 - 같은 클래스 내에서만 접근 가능
//        b1.color = "black"; // protected - 접근불가 - 같은 패키지 or 타 패키지면 자식 클래스만
    }
}
```


## tips
- Command + Click 하면 해당 메서드 소스코드 볼 수 있음 