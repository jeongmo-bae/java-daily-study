package theme5_java_functional_programming.quiz;

public class Customer {
    String name;
    int age;
    Customer(String name, int age){
        this.name = name;
        this.age = age;
    }
    Customer(){
        this("Unknown",0);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
