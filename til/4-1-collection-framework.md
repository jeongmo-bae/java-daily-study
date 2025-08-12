# 2025-08-12 TIL

## Collection
- List
  - ArrayList
  - LinkedList
- Set
- Map

---

### List
#### ArrayList
- java.util.ArrayList
```java
ArrayList<String> arrayList = new ArrayList<>();
```
- .add()
- .remove()
- .get()
- .set()
- .indexOf()
- .size()
- .contains()
- .clear()
- .isEmpty()
- Collections.sort(ArrayList,Comparator)
- Collections.reverseOrder()
```java
import java.util.ArrayList;
public static void main(String[] args) {
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("배정모");
    arrayList.add(0,"qowjdah");
    arrayList.set(0,"배정모모");
    arrayList.get(0);
    arrayList.size();
    String first = arrayList.remove(0);
    String last =  arrayList.remove(arrayList.size()-1);
    System.out.println(arrayList.indexOf("신주연"));
    if (arrayList.contains("신주연")){
      System.out.println("수강신청 성공");
    }else {
      System.out.println("수강신청 실패");
    }
    Collections.sort(arrayList,Collections.reverseOrder());
    System.out.println(arrayList);
    arrayList.clear();
    if(arrayList.isEmpty()){
      System.out.println("비어있습니다");
    }else{
      System.out.println(arrayList.size());
    }
    
}
```

#### LinkedList
- java.util.LinkedList
```java
LinkedList<Integer> linkedList = new LinkedList<>();
```
- add / remove / get / set / indexOf / size / contains / clear / isEmpty / Collections.sort
- addFirst() / addLast()
- removeFirst() / removeLast()
- getFirst() / getLast()
- setFirst() / setLast()

---

### Set