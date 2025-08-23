package theme3_generics.user;

public class User {
    public String name;

    public User(String name) {
        this.name = name;
    }
    public void addPoint(){
        System.out.println(this.name + "남 포인트 적립 되었습니다.");
    }
}
