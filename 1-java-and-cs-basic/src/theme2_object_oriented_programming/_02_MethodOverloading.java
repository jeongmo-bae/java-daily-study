package theme2_object_oriented_programming;

public class _02_MethodOverloading {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.modelName = "mx-master";
        b1.record(true,true,1);
        System.out.println("--------------------------------");
        b1.record(true,false,3);
        System.out.println("--------------------------------");
        b1.record(false,false,5);
        System.out.println("----------------overloading----------------");
        b1.record();

        String s = "BlackBox";
        System.out.println(s.indexOf("a"));
    }

}
