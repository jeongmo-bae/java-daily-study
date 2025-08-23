package theme2_object_oriented_programming;

import theme2_object_oriented_programming.camera.Camera;

public class _12_Reference {
    public static void main(String[] args) {
        // Primitive Data Types : null 이 없음 / method 가 없음
        int[] i = new int[3];
        System.out.println(i[0]); // 0

        double[] d = new double[3];
        System.out.println(d[0]); // 0.0

        // Reference Data Types : String, Integer, Camera, SpeedCam ...
        Camera[] cameras = new Camera[2];
        System.out.println(cameras[0]); // null

        // Primitive 는 값 자체를 담음 / Reference 는 참조를 담음
    }
}
