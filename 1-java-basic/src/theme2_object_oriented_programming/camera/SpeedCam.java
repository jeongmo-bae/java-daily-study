package theme2_object_oriented_programming.camera;

public class SpeedCam extends Camera {

    // Command + N : generator 단축키
    public SpeedCam() {
        super("SpeedCam");
    }
    public void takePicture(){
        super.takePicture();
        checkSpeed();
        recognizeLicensePlate();
    }
    public void checkSpeed(){
        System.out.println("속도를 측정합니다.");
    }
    public void recognizeLicensePlate(){
        System.out.println("차량번호를 인식합니다.");
    }
    @Override // annotation : 뜻은 주석인데, 컴파일러에게 부모 클래스의 메서드를 오버라이딩 하는거야 라고 말해주는 것. -> 부모클래스에 없는데 @Override 쓰면? 에러남!
    public void showMainFeature() {
        System.out.println(super.getName() + " 의 주요기능 : 속도 측정, 차량번호 인식");
    }
}
