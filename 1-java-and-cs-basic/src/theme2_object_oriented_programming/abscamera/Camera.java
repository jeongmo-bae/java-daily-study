package theme2_object_oriented_programming.abscamera;

public abstract class Camera {
    public void takePicture(){
        System.out.println("사진을 촬영합니다");
    }
    public void recordVideo(){
        System.out.println("동영상을 녹화합니다");
    }
    // abstract method
    // 자식 클래스에서 구현해주어야함!
    public abstract void showMainFeature();
}
