package theme2_object_oriented_programming;

import theme2_object_oriented_programming.camera.Camera;
import theme2_object_oriented_programming.camera.FactoryCam;
import theme2_object_oriented_programming.camera.SpeedCam;

public class _09_MethodOverriding {
    public static void main(String[] args) {
        // method overriding : 자식 클래스에서 부모 클래스의 메서드를 덮어쓰는 것(재정의)
        Camera camera = new Camera();
        FactoryCam factoryCam = new FactoryCam();
        SpeedCam speedCam = new SpeedCam();

        camera.showMainFeature();
        factoryCam.showMainFeature();
        speedCam.showMainFeature();
    }
}
