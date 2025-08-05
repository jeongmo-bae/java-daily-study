package theme2_object_oriented_programming;

public class _06_GetterSetter {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox("mx","",100000,"white");
        String color = b1.getColor();
        b1.setPrice(55000);
        int price = b1.getPrice();
        String resol = b1.getResolution();
        System.out.println(color + " / " + price + " / " + resol );
    }
}
