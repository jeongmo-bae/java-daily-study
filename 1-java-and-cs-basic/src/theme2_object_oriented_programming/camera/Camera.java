package theme2_object_oriented_programming.camera;

public class Camera {
    public String name;

    public Camera() {
        this.name = "camera";
    }
    public void takePicture(){
        System.out.println(this.name + " : 사진을 촬영합니다");
    }
    public void recordVideo(){
        System.out.println(this.name + " : 동영상을 녹화합니다");
    }
    public void showMainFeature(){
        System.out.println(this.name + " 의 주요기능 : 사진 촬영, 동영상 녹화");
    }

}
