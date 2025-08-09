package theme2_object_oriented_programming.detector;

public interface Detectable {
    // interface 안에서 면수 정의하면 public static final 자동
    // 메서드는 public abstract 자동
    /*public static final*/ String name = "감지자";
    /*public abstract*/ void detect();
    //default void detect(){}; java 8 부터 생김
}
