package theme2_object_oriented_programming;

public class _01_Class {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.modelName = "b1";
        b1.color = "Black";
        b1.price = 200000;
        b1.resolution="FHD";
        BlackBox b2 = new BlackBox();
        b2.modelName = "mx-master";

        // class variable test
        System.out.println("---자동 신고 기능 개발 전---");
        System.out.println(b1.modelName + " 자동 신고 기능 : " + b1.canAutoReport );
        System.out.println(b2.modelName + " 자동 신고 기능 : " + b2.canAutoReport );
        System.out.println("모든 블랙박스 제품의 자동 신고 기능 : " + BlackBox.canAutoReport);

        BlackBox.canAutoReport = true;

        System.out.println("---자동 신고 기능 개발 후---");
        System.out.println(b1.modelName + " 자동 신고 기능 : " + b1.canAutoReport );
        System.out.println(b2.modelName + " 자동 신고 기능 : " + b2.canAutoReport );
        System.out.println("모든 블랙박스 제품의 자동 신고 기능 : " + BlackBox.canAutoReport);

        b1.autoReport();
        b1.alertInsertMemCard(64);
    }
}
