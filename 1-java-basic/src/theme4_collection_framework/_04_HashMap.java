package theme4_collection_framework;

import java.util.HashMap;
import java.util.Map;

public class _04_HashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("AAA",1);
        map.put("BBB",2);
        map.put("CCC",3);
        System.out.println(map.size());
        System.out.println(map);
        if(map.containsKey("AAA")){
            map.put("AAA",map.get("AAA")+1);
            System.out.println(map);
        }

        // 삭제
        map.remove("AAA");
        System.out.println(map);

        // 순회
        for (String key : map.keySet()){
            System.out.println(key);
        }
        for (Integer value :  map.values()){
            System.out.println(value);
        }
        for (Map.Entry<String, Integer> entry :  map.entrySet()){
            String key = entry.getKey();
            Integer value =  entry.getValue();
            System.out.println("Key  : " + key +  " , Value : "  + value);
        }
        System.out.println(map.entrySet());
        System.out.println(map.entrySet().getClass());
    }
}
