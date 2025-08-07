package theme2_object_oriented_programming.camera;

public class FactoryCam extends Camera {

    public FactoryCam() {
        this.name = "factoryCam";
    }
    public void detectFire(){
        System.out.println("화재를 감지합니다.");
    }
    // method overriding
    public void showMainFeature(){
        System.out.println(this.name + " 의 주요기능 : 화재 감지");
    }
}
