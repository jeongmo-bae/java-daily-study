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

    // getterSetter
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getResolution() {
        if(resolution == null || resolution.isEmpty()){
            return "판매자에게 문의해 주세요";
        } else {
            return resolution;
        }
    }
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    public int getPrice() {
        if (this.price > 100000){
            return price;
        } else {
            return 100000;
        }
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    // method
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

    // method overloading
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
