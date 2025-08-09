package theme2_object_oriented_programming.quiz;

public class Main {
    public static void main(String[] args) {
        Burger[] burgers = new Burger[3];
        burgers[0] = new Burger();
        burgers[1] = new CheezeBurger("엄마상어치즈버거", new String[] {"치즈","소고기패티","양상추","양파","햄"});
        burgers[2] = new ShrimpBurger("아기상어새우버거", new String[] {"새우","소고기패티","양상추","양파","햄","피클"});

        System.out.println("----------------------");
        for (Burger burger : burgers) {
            System.out.printf("주문하신 메뉴는 %s 입니다.\n조리를 시작합니다.\n", burger.getName());
            burger.cook();
            System.out.println("----------------------");
        }
    }
}
