package theme2_object_oriented_programming;

import theme2_object_oriented_programming.abscamera.FactoryCam;
import theme2_object_oriented_programming.detector.*;
import theme2_object_oriented_programming.reporter.*;

public class _16_Interface {
    public static void main(String[] args) {
        // interface
        // 뼈대만 제공하는 구조?
        // 상속(inheritance) 는 하나만 되지! -> interface 를 쓰면 이런 문제점을 해결가능!
        Reportable normalReporter = new NormalReporter();
        normalReporter.report();
        Reportable videoReporter = new VideoReporter();
        videoReporter.report();

        Detectable fireDetector = new FireDetector();
        fireDetector.detect();
        Detectable advancedFireDetector = new AcvancedFireDetector();
        advancedFireDetector.detect();
        System.out.println("==============================");
        FactoryCam factoryCam = new FactoryCam();
        factoryCam.setDetector(fireDetector);
        factoryCam.setReporter(normalReporter);
        factoryCam.detect();
        factoryCam.report();

    }
}
