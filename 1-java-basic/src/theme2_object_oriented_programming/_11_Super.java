package theme2_object_oriented_programming;

import theme2_object_oriented_programming.camera.FactoryCam;
import theme2_object_oriented_programming.camera.SpeedCam;

public class _11_Super {
    public static void main(String[] args) {
        FactoryCam factoryCam = new FactoryCam();
        SpeedCam speedCam = new SpeedCam();
        factoryCam.recordVideo();
        System.out.println("==========================");
        speedCam.takePicture();
    }
}
