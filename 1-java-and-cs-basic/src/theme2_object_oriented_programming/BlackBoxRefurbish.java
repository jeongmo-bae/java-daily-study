package theme2_object_oriented_programming;

public class BlackBoxRefurbish {
    public String modelName;    // public
    String resolution;  // default
    private int price;  // private
    String color;   // protected

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getResolution() {
        if(resolution == null || resolution.isEmpty()){
            return "판매자에게 문의해 주세요";
        } else {
            return resolution;
        }
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 100000){
            this.price = price;
        } else {
            this.price = 100000;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class A{

}