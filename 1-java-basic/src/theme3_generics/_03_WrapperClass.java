package theme3_generics;

public class _03_WrapperClass {
    public static void main(String[] args) {
        Integer i = 123;
        Double d = 1.0;
        Character c ='A';
        System.out.println(i + " " + d + " " + c);

        System.out.println(i.doubleValue());
        System.out.println(c.charValue());
        System.out.println(d.intValue());
        String s = i.toString();
        System.out.println(s);
    }
}
