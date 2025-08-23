package theme2_object_oriented_programming;

import theme2_object_oriented_programming.abscamera.Camera;
import theme2_object_oriented_programming.abscamera.FactoryCam;
import theme2_object_oriented_programming.abscamera.SpeedCam;

public class _15_AbstractClass {
    public static void main(String[] args) {
        // 데이터 추상화 (Data Abstraction)
        // 추상 클래스 : 아직 완성되지 않은 클래스 - 객체화 불가
        // 추상 메서드 : 추상 클래스에서만 사용 가능한, 껍데기만 있는 메서드
        // Camera camera = new Camera(); -> 객체화 불가능!
        FactoryCam factoryCam = new FactoryCam();
        SpeedCam speedCam = new SpeedCam();
        factoryCam.showMainFeature();
        speedCam.showMainFeature();

    }
}
