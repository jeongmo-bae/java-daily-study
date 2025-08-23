package theme5_java_functional_programming;

import theme5_java_functional_programming.converter.Convertible;

public class _03_FunctionalInterface {
    public static void main(String[] args) {
        //KRWConverter converter= new KRWConverter();
        //converter.convert(2);
        convertUSD( USD -> System.out.println(USD + "달러 = " + (USD * 1400) +" 원"),2);
    }

    public static void convertUSD(Convertible converter,int USD){
        converter.convert(USD);
    }
}
