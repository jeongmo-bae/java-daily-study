package theme2_object_oriented_programming;

import theme2_object_oriented_programming.camera.Camera;
import theme2_object_oriented_programming.camera.FactoryCam;
import theme2_object_oriented_programming.camera.SpeedCam;

public class _08_Inheritance {
    public static void main(String[] args) {
        Camera camera = new Camera();
        FactoryCam factoryCam = new FactoryCam();
        SpeedCam speedCam = new SpeedCam();

        System.out.println(camera.getName());
        System.out.println(factoryCam.getName());
        System.out.println(speedCam.getName());
        camera.takePicture();
        factoryCam.recordVideo();
        speedCam.takePicture();
        factoryCam.detectFire();
        speedCam.checkSpeed();
        speedCam.recognizeLicensePlate();

    }
}
