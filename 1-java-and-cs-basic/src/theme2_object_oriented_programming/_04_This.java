package theme2_object_oriented_programming;

public class _04_This {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.modelName = "This"; // modelName 업데이트 하고싶어
        b1.appendModelName("(최신형)");
        System.out.println(b1.getModelName());
    }
}
