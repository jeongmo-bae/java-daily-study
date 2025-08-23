package theme5_java_functional_programming.quiz;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> custList = new ArrayList<>();
        HashMap<String, Integer> custMap = new HashMap<>();
        custMap.put("챈들러",50);
        custMap.put("레이첼",42);
        custMap.put("모니카",21);
        custMap.put("밴저만",18);
        custMap.put("제임스",5);
        Iterator<Map.Entry<String, Integer>> iteratorOfcustMap = custMap.entrySet().iterator();
        while (iteratorOfcustMap.hasNext()){
            Map.Entry<String,Integer> nextIter = iteratorOfcustMap.next();
            String name = nextIter.getKey();
            int age = nextIter.getValue();
            custList.add(new Customer(name, age));
        }
    custList.stream()
            .sorted((a, b) -> {
                int c = Integer.compare(b.getAge(), a.getAge());
                if (c != 0) return c;
                return a.getName().compareTo(b.getName());
            })
            .map(x -> x.getAge() >= 20 ? x.getName() + " 5000원" : x.getName() + " 무료" )
            .forEach(System.out::println);
    }
}
