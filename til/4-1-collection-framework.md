# 2025-08-12 TIL

## Collection
- List
  - ArrayList
  - LinkedList
- Set
- Map

---

### List

- ArrayList vs LinkedList 비교

| 구분 | ArrayList | LinkedList |
|------|-----------|------------|
| **저장 구조** | 배열 기반 | 이중 연결 리스트(Doubly Linked List) 기반 |
| **조회 속도** | 빠름 (O(1), 인덱스로 바로 접근 가능) | 느림 (O(n), 앞에서부터 순차 탐색) |
| **삽입/삭제 속도** | 느림 (O(n), 중간에서 삽입/삭제 시 요소 이동 필요) | 빠름 (O(1), 참조만 변경) — 단, 노드 탐색이 먼저 필요해서 O(n) |
| **메모리 사용량** | 상대적으로 적음 (데이터만 저장) | 많음 (데이터 + 이전/다음 노드 참조 저장) |
| **랜덤 접근** | 지원 (인덱스 기반 접근) | 미지원 (순차 접근만 가능) |
| **순차 추가** | 빠름 (O(1), 배열 크기 초과 시 재할당 발생) | 빠름 (O(1)) |
| **중간 삽입/삭제** | 느림 (O(n)) | 상대적으로 빠름 (O(1) 참조 변경, 단 탐색 필요) |
| **스레드 안전성** | 기본적으로 비동기 (필요 시 Collections.synchronizedList()로 감싸야 함) | 기본적으로 비동기 |

- 선택 기준
  - **조회 위주** >> `ArrayList`
  - **삽입/삭제가 잦음** >> `LinkedList`
  - 실무에서는 거의 대부분 **ArrayList**를 쓰고, `LinkedList`는 메모리 부담과 탐색 성능 때문에 잘 안 쓰는 편

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