package theme3_generics.coffee;

import theme3_generics.user.User;
// User 혹은 그를 상속하는 것만 받겠다
public class CoffeeByUser <T extends User>{
    public T user;

    public CoffeeByUser(T user) {
        this.user = user;
    }
    public void ready(){
        System.out.println("커피 준비 완료 : " + user.name);
        user.addPoint();
    }
}
