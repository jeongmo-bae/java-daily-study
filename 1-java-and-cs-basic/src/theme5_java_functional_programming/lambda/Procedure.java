package theme5_java_functional_programming.lambda;

// 정확히 하나의 추상 메서드를 가지는 인터페이스 (SAM : Single Abstract Method)
// FunctionalInterface Annotation : Compile 단계에서 Interface of SAM 보장을 위해 사용
@FunctionalInterface
public interface Procedure {
    void run();
}
