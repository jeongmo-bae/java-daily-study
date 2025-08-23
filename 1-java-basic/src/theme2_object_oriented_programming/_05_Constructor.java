package theme2_object_oriented_programming;

public class _05_Constructor {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox("MX-MASTER","FHD",2000000,"black");
        BlackBox b2 = new BlackBox();
        BlackBox b3 = new BlackBox();
        BlackBox b4 = new BlackBox();
        System.out.println("-----b1-----");
        System.out.println(b1.modelName);
        System.out.println(b1.resolution);
        System.out.println(b1.price);
        System.out.println(b1.color);
        System.out.println(b1.serialNo);
        System.out.println("-----b2-----");
        System.out.println(b2.serialNo);
        System.out.println("-----b3-----");
        System.out.println(b3.serialNo);
        System.out.println("-----b4-----");
        System.out.println(b4.serialNo);
    }
}
