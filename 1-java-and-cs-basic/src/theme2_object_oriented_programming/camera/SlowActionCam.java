package theme2_object_oriented_programming.camera;

public class SlowActionCam extends ActionCam{
    public SlowActionCam(){
        super("슬로우 액션 카메라");
    }
    // 부모 클래스에서 final 로 정의해서 오버라이딩 불가능!
//    @Override
//    public void makeVideo() {
//        //super.makeVideo();
//        System.out.println(super.getName() + " : " + this.lens + " 로 촬영한 슬로우 비디오를 제작합니다.");
//    }
    public void makeSlowVideo(){
        System.out.println(super.getName() + " : " + this.lens + " 로 촬영한 슬로우 비디오를 제작합니다.");
    }

}
