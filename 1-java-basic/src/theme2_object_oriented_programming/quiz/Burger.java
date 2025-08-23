package theme2_object_oriented_programming.quiz;

import java.util.Arrays;

public class Burger {
    private String name ;
    private String[] ingredients;
    //constructor

    public Burger() {
        this("햄버거", new String[] {"소고기패티", "양파", "양상추"});
    }
    Burger(String name){
        this(name, new String[] {"소고기패티", "양파", "양상추"});
    }
    Burger(String name, String[] ingredients){
        this.name = name;
        this.ingredients = ingredients ;
    }
    // method
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIngredients() {
        return Arrays.toString(ingredients);
    }
    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public void cook(){
        System.out.println(this.getName() + " 에 사용된 재료 : ");
        for (int i = 0; i < this.ingredients.length; i++) {
            if (i==0){
                System.out.println("> " + ingredients[i]);
            } else {
                System.out.println("+ " + ingredients[i]);
            }
        }
    }
}

class CheezeBurger extends Burger{
    //constructor
    CheezeBurger(String name, String[] ingredients){
        super(name);
        super.setIngredients(ingredients);
    }
}
class ShrimpBurger extends Burger{
    ShrimpBurger(String name, String[] ingredients){
        super(name);
        super.setIngredients(ingredients);
    }
}