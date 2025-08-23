package theme2_object_oriented_programming.camera;

public class FactoryCam extends Camera {

    public FactoryCam() {
        //this.name = "factoryCam";
        super("factoryCam");
    }
    public void recordVideo(){
//        System.out.println(this.name + " : 동영상을 녹화합니다");
        super.recordVideo(); // overriding 을 하되, super 로 상속의 이점을 가져가는거지
        detectFire();
    }
    public void detectFire(){
        System.out.println("화재를 감지합니다.");
    }
    // method overriding
    public void showMainFeature(){
        System.out.println(super.getName() + " 의 주요기능 : 화재 감지");
    }
}
