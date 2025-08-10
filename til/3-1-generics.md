# 2025-08-10 TIL

## Generics
- 타입에 대한 의존성을 없애, 코드 중복을 줄일 수 있음
```java
    public static void main(String[] args) {
        Integer[] iArray = {1,2,3,4,5};
        Double[] dArray = {1.0,2.0,3.0,4.0,5.0};
        String[] sArray = {"a","b","c","d","e"};

        printAnyArray(iArray);
        printAnyArray(dArray);
        printAnyArray(sArray);
    }
    private static <T> void printAnyArray(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
```
- Generics - 객체만 지원 - primitive 불가능
- Type Parameter(Type Variavle) -> T : Type / K : Key / V : Value / E : Element

## Generic Class
- class 도 똑같다
```java
public class CoffeeByAny<T> {
    public T name;
    public CoffeeByAny(T name) {
        this.name = name;
    }
    public void ready(){
        System.out.println("커피 준비 완료 : "+name);
    }
}
```
- 만약 타입을 제한하고 싶다면?
- 아해 처럼 User 클래스로 제한할 수 있음(User 를 상속한 것 까지 포함)
```java
import theme3_generics.user.User;
// User 혹은 그를 상속하는 것만 받겠다
public class CoffeeByUser <T extends User>{
    public T user;

    public CoffeeByUser(T user) {
        this.user = user;
    }
    public void ready(){
        System.out.println("커피 준비 완료 : " + user.name);
        user.addPoint();
    }
}
```
## Type Parameter(Type Variable)
| 조합 | 의미 | 사용 예시 |
|------|------|----------|
| `<T, U>` | Type1, Type2 (가장 흔함) | `Pair<T, U>` |
| `<L, R>` | Left, Right | `Pair<L, R>` |
| `<K, V>` | Key, Value (Map 성격일 때) | `Map.Entry<K, V>` |
| `<A, B>` | 값 2개 단순 구분 | 커스텀 DTO 등에서 |
| `<X, Y>` | 좌표나 매핑 | `Point<X, Y>` |

## Diamond Operator
- java 7 부터 도입됨
- 타입을 추론해 줌 -> 두번 써줘야하는 불편함 해소
```java
CoffeeOrder<String, String> order = new CoffeeOrder<>("영희", "아메리카노");

public static <T,V>  CoffeeOrder<T,V> orderCoffee(T name, V coffee){
    return new CoffeeOrder<>(name,coffee);
}
```
