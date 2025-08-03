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


## tips
- Command + Click 하면 해당 메서드 소스코드 볼 수 있음 