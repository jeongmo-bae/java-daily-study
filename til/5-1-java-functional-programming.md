# 2025-08-16 TIL

## Functional Programming
- 함수를 값처럼 다루는 프로그래밍 패러다임
  - 변수에 함수를 담을 수 있고
  - 함수의 인자로 다른 함수를 넘길 수 있고
  - 함수가 다른 함수를 리턴할 수도 있는 거
  - 고차 함수(Higher-order function)
- 명령형(Imperative, 전통적인 자바 방식) : 단계별 명령


## 명령형 vs 함수형 프로그래밍

### 명령형(Imperative, 전통적인 자바 방식)
- 단계별 지시
```java
List<String> names = Arrays.asList("a", "bb", "ccc");
List<String> result = new ArrayList<>();

for (String s : names) {
    if (s.length() >= 2) {
        result.add(s.toUpperCase());
    }
}
```
### 함수형(Functional, Java8 이후 가능)
- 함수 조합으로 선언적으로 표현
```java
List<String> result = names.stream()
                           .filter(s -> s.length() >= 2)
                           .map(String::toUpperCase)
                           .toList();
```

## 함수형 프로그래밍의 주요 특징
- **함수를 값으로 다룸**
```java
Function<Integer, Integer> square = x -> x * x;
System.out.println(square.apply(5)); // 25
```
- **불변성(Immutable)**
  - 기존 자료를 변경하지 않고 새로운 값을 만들어 사용 
  - 멀티스레드 환경에서 안정성 보장
- **부수 효과(Side-effect) 최소화**
  - 같은 입력 → 같은 출력(순수 함수, Pure Function) 지향
  - 전역 변수 수정, I/O 같은 부수 효과를 줄임
- **선언형 스타일**
  - "for 돌려서 처리"가 아니라, **필터링(filter)**, **매핑(map)**,**리듀스(reduce)** 같은 **무엇을** 하고 싶은지 선언


## 왜 중요한가?
- Java 8 이후 **람다, 스트림, Optional** 등이 도입되면서 함수형 프로그래밍은 자바의 표준 스타일이 됨
- 코드가 **간결**, **가독성 향상**
- **병렬 처리 및 데이터 파이프라인 처리에 효과적**

## 정리
함수형 프로그래밍은
- **함수를 1급 객체로 다룸**
- **부수 효과를 최소화**
- **선언형 스타일**을 지향하는 프로그래밍 패러다임

>자바에서는 **람다, 함수형 인터페이스, 스트림** 등을 통해 함수형 프로그래밍 스타일을 지원한다.
---
## 자바에서 함수형 프로그래밍을 위한 도구

- **익명 클래스(Anonymous Class)** : 함수형 스타일 도입 전의 대안
- **람다식(Lambda Expression)** : 함수 자체를 값으로 다루는 간결한 문법
- **함수형 인터페이스(Functional Interface)** : `@FunctionalInterface` 어노테이션으로 단일 추상 메서드만 가진 인터페이스
-  **스트림 API(Stream API)** : 컬렉션 데이터를 선언적·함수형 스타일로  처리

## 상세 정리
### Anonymous Class
```java
package theme5_java_functional_programming;

public class _01_AnonymousClass {
  public static void main(String[] args) {
    Coffee c1 = new Coffee();
    c1.order("아메리카노");
    c1.returnTray();
    System.out.println("=====================");
    // 익명 클래스
    Coffee specialCoffee  = new Coffee(){
      @Override
      public void order(String coffee) {
        super.order(coffee);
        System.out.println("(귓속말) 딸기케이크는 서비스에요");
      }

      @Override
      public void returnTray() {
        System.out.println(" (귓속말)내가 치울게");
      }
    };
    specialCoffee.order("바닐라라떼");
    specialCoffee.returnTray();
  }
}
class Coffee{
  public void order(String coffee){
    System.out.println(coffee + " 나왔어요");
  }
  public void returnTray(){
    System.out.println("쟁반 반납이 완료되었습니다");
  }
}
```

### Lambda Expression
- JAVA 8 부터 가능해짐
- 자바 람다에 대해 제대로 이해하려면 먼저 내부 클래스에 대해 확실한 이해가 필요
- Anonymous Class 심화
- 자바에서 메서드의 매개변수에 인수로 전달할 수 있는 것은 크게 2가지이다.
  - `int` , `double` 과 같은 기본형 타입
    `Procedure` `Member` 와 같은 참조형 타입(인스턴스)
  - 결국 메서드에 인수로 전달할 수 있는 것은 간단한 값이나, 인스턴스의 참조이다.
- 클래스나 인스턴스와 관계 없이 다음과 같이 직접 코드 블럭을 전달할 수 있다면 더 간단하지 않을까?
- 기본 구조 : (parameter) -> {Context}
```java
// .lambda.Procedure
package theme5_java_functional_programming.lambda;

@FunctionalInterface
public interface Procedure {
  void run();
}

// .lambda.start.Ex1Main
Procedure dice = () -> {
    int randomValue = new Random().nextInt(6) + 1;
    System.out.println("주사위 = " + randomValue);
};
Procedure sum = () -> {
    for (int i = 1; i <= 3; i++) {
        System.out.println("i = " + i);
    }
};
```
#### Why Lambda?
- **값 매개변수화(Value Parameterization)**
  - 문자값(**Value**), 숫자값(**Value**)처럼 구체적인 값을 메서드(함수) 안에 두는 것이 아니라, **매개변수**(파라미터)를
  통해 외부에서 전달 받도록 해서, 메서드의 동작을 달리하고, 재사용성을 높이는 방법을 **값 매개변수화**라 한다.
  - 값 매개변수화, 값 파라미터화 등으로 부른다.
- **동작 매개변수화(Behavior Parameterization)**
  - 코드 조각(코드의 동작 방법, 로직, **Behavior**)을 메서드(함수) 안에 두는 것이 아니라, **매개변수**(파라미터)를 통
  해서 외부에서 전달 받도록 해서, 메서드의 동작을 달리하고, 재사용성을 높이는 방법을 동작 매개변수화라 한다.
  - 동작 매개변수화, 동작 파라미터화, 행동 매개변수화(파라미터화), 행위 파라미터화 등으로 부른다.
- **정리하면 다음과 같다.**
  - **값 매개변수화**: 값(숫자, 문자열 등)을 바꿔가며 메서드(함수)의 동작을 달리 함
  - **동작 매개변수화**: 어떤 동작(로직)을 수행할지를 메서드(함수)에 전달(인스턴스 참조, 람다 등)
- **코드 조각도 넘겨 줄 수 있으면 좋겠다!!!** -> 이게 여태 껏 없었지 -> lambda expression
- 결국 변하는 부분을 어떻게 분리하여 처리할 수 있을까 가 핵심이야



### Functional Interface
```java
package theme5_java_functional_programming.converter;

@FunctionalInterface
public interface Convertible {
    void convert(int USD);
}

```

### Stream
- Stream 생성 방법 **Stream<T>** 
  - Arrays.stream()
  - Collection.stream()
  - Stream.of()
```java
// Arrays.stream()
int[]  scores= {100,95,90,85,80};
IntStream scoreStream = Arrays.stream(scores);
String[] langs = {"python","java","javascript","c","c#"};
Stream<String> langStream = Arrays.stream(langs);
// Collection.Stream()
List<String> langList = new ArrayList<>();
langList = Arrays.asList("python","java","javascript","c","c#");
Stream<String> langListStream = langList.stream();
// Stream.of()
Stream<String> langListOfStream = Stream.of("python", "java", "javascript", "c", "c#");
```
- 중간 연산은 **체이닝 가능한 스트림을 반환하며 최종 연산이 호출되기 전에는 실행되지 않는다.** 
- 최종 연산은 **스트림 파이프라인을 실행**시키고 결과를 만들며 스트림을 닫는다.
```java
custList.stream()
        .sorted((a, b) -> {
          int c = Integer.compare(b.getAge(), a.getAge());
          if (c != 0) return c;
          return a.getName().compareTo(b.getName());
        })
        .map(x -> x.getAge() >= 20 ? x.getName() + " 5000원" : x.getName() + " 무료" )
        .forEach(System.out::println);
```


