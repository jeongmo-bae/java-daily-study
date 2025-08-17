package theme7_thread.quiz;

public class Product implements Productable{
    public String name;
    private int number  = 1;
    Product(String name){
        this.name = name;
    }
    @Override
    public void make() {
        System.out.println("(" + this.name + ") 상품 "  +  this.number  +" / 5 제작 완료");
        number++;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
