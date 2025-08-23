package theme2_object_oriented_programming.abscamera;

import theme2_object_oriented_programming.detector.Detectable;
import theme2_object_oriented_programming.reporter.Reportable;

public class FactoryCam extends Camera implements Detectable, Reportable {
    // Variable
    private Detectable detector;
    private Reportable reporter;
    // Method
    public void setDetector(Detectable detector) {
        this.detector = detector;
    }

    public void setReporter(Reportable reporter) {
        this.reporter = reporter;
    }
    @Override
    public void showMainFeature() {
        System.out.println("화재 감지");
    }
//    public void detect(){
//        System.out.println("화재를 감지합니다");
//    }
//    public void report(){
//        System.out.println("화재 신고를 진행합니다");
//    }

    @Override
    public void detect() {
        detector.detect();
    }

    @Override
    public void report() {
        reporter.report();
    }
}

