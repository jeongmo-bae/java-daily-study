package theme2_object_oriented_programming;

import theme2_object_oriented_programming.camera.ActionCam;
import theme2_object_oriented_programming.camera.SlowActionCam;

public class _13_Final {
    // Final
    // public (final) class / void /
    // public >  abstract > static > final >>>
    public static void main(String[] args) {
        ActionCam actionCam = new ActionCam();
        actionCam.recordVideo();
        //actionCam.lens = "표준렌즈";
        actionCam.makeVideo();
        System.out.println("====================");
        SlowActionCam slowActionCam =new SlowActionCam();
        //slowActionCam.makeVideo();  // SlowActionCam 의 부모 클래스인 ActionCam 에서  makeVideo 를 final 로 선언하여 오버라이딩 불가
        slowActionCam.makeSlowVideo();
    }
}
