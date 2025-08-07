package theme2_object_oriented_programming;

import theme2_object_oriented_programming.camera.Camera;
import theme2_object_oriented_programming.camera.FactoryCam;
import theme2_object_oriented_programming.camera.SpeedCam;

public class _10_Polymorphism {
    public static void main(String[] args) {
        // class Person
        // class Student extends Person : Student is a Person
        // class Teacher extends Person : Teacher is a Person
        // inheritance -> IS-A 관계

        // 부모클래스는 자식클래스 객체를 만들 수 있다. -> 다형성
        Camera camera = new Camera();
        Camera speedCam = new SpeedCam();
        Camera factoryCam = new FactoryCam();

        camera.showMainFeature();
        speedCam.showMainFeature();
        factoryCam.showMainFeature();
        System.out.println("========================");
        Camera[] cameras = new Camera[3];
        cameras[0] = new Camera();
        cameras[1] = new FactoryCam();
        cameras[2] = new SpeedCam();
        for (Camera cam : cameras) {
            cam.showMainFeature();
        }
        System.out.println("========================");

        if (camera instanceof Camera){
            System.out.println("This is a Camera");
        }
//        factoryCam.detectFire();
        if (factoryCam instanceof FactoryCam){
            ((FactoryCam) factoryCam).detectFire();
        }
        if (speedCam instanceof SpeedCam){
            ((SpeedCam) speedCam).recognizeLicensePlate();
            ((SpeedCam) speedCam).checkSpeed();
        }
        System.out.println("========================");
        // Object 클래스는 모든 클래스가 상속하는 클래스임(자바에서)
        Object[] objects = new Object[3];
        objects[0] = new Camera(); //auto upcasting
        objects[1] = new SpeedCam();
        objects[2] = new FactoryCam();
        for (Object obj : objects) {
            ((Camera) obj).showMainFeature(); //down casting
        }
    }
}
