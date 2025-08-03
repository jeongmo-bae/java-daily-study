package theme2_object_oriented_programming;

import java.util.SplittableRandom;

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
    BlackBox(){
        this.serialNo = ++counter;
        System.out.println("Constructor setting is complete : serialNO="+this.serialNo);
    }
    BlackBox(String modelName, String resolution , int price, String color) {
        this();
        this.modelName = modelName;
        this.resolution = resolution;
        this.price = price;
        this.color = color;
    }

    // Method
    // getModelName method
    String getModelName() {
        return this.modelName;
    }
    // getResolution method
    String getResolution() {
        return this.resolution;
    }
    // autoReport
    int autoReport(){
        if(this.canAutoReport) {
            System.out.println("충돌이 감지되어 자동으로 신고합니다");
            return 1;
        } else{
            System.out.println("자동 신고 기능이 지원되지 않는 모델입니다");
            return 0;
        }
    }
    void alertInsertMemCard(int capacity){
        System.out.println("메모리 카드가 삽입 되었습니다.\n용량은 " + capacity + "GB 입니다.");
    }
    // showDateTime : 날짜 정보 포함 여부
    // showSpeed : 속도 정보 표시 여부
    // min : 영상 기록 단위(분)
    void record(boolean showDateTime, boolean showSpeed, int min){
        System.out.println("녹화를 시작합니다.");
        if(showDateTime){
            System.out.println("영상에 날짜 정보가 포함됩니다.");
        }
        if(showSpeed){
            System.out.println("영상에 속도 정보가 포함됩니다.");
        }
        System.out.println("영상은 " + min + "분 단위로 기록됩니다");
    }
    // Method overloading
    void record(){
        record(true,true,5);
    }
    // Class method
    static void callServiceCenter(){
        System.out.println("서비스 센터로 연결합니다");
        //modelName = "TEST"; java: non-static variable modelName cannot be referenced from a static context
    }
    // This
    void  appendModelName(String modelName) {
        this.modelName += modelName;
    }
}
