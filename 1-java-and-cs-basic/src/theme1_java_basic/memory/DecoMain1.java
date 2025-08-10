package theme1_java_basic.memory;

public class DecoMain1 {
    public static void main(String[] args) {
        String s = "Hello Java";
        DecoUtil1 utils = new DecoUtil1();
        // 인스턴스 메서드
        String deco = utils.deco(s);
        System.out.println(deco);

        // 정적 메서드 (클래스 메서드)
        // static method 를 활용해서, 인스턴스 생성 없이 바로 class 통해서 바로 호출 가능
        String deco2 = DecoUtil2.deco(s);
        System.out.println(deco2);
    }
}
