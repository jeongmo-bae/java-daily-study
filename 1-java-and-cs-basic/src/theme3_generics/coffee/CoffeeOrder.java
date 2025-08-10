package theme3_generics.coffee;

import theme3_generics.user.User;

public class CoffeeOrder<T , U> {
    private final T name;
    private final U coffee;

    public CoffeeOrder(T name, U coffee) {
        this.name = name;
        this.coffee = coffee;
    }
    public T getName() {
        return name;
    }
    public U getCoffee() {
        return coffee;
    }
}