package theme3_generics.coffee;

public class CoffeeByAny<T> {
    public T name;

    public CoffeeByAny(T name) {
        this.name = name;
    }
    public void ready(){
        System.out.println("커피 준비 완료 : "+name);
    }
}
