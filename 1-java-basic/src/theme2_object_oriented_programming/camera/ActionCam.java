package theme2_object_oriented_programming.camera;

// final 로 class 선언하면 상속 못함
public class ActionCam extends Camera{
    public final String lens; //= "광각렌즈";
    public ActionCam(){
        this("액션 카메라");
    }
    public ActionCam(String name){
        super(name);
        this.lens =  "광각렌즈";
    }

    public final void makeVideo(){
        System.out.println(super.getName() + " : " + this.lens + " 로 촬영한 비디오를 제작합니다.");
    }
}
