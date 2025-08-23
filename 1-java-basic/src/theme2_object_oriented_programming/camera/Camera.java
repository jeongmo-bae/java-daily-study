package theme2_object_oriented_programming.camera;

public class Camera {
    private String name;

    public Camera() {
        this("camera");
    }
    protected Camera(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
