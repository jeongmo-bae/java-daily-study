# 2025-08-16 TIL

## Functional Programming
- 함수를 값처럼 다루는 프로그래밍 패러다임
  - 변수에 함수를 담을 수 있고
  - 함수의 인자로 다른 함수를 넘길 수 있고
  - 함수가 다른 함수를 리턴할 수도 있는 거
  - 고차 함수(Higher-order function)
- 명령형(Imperative, 전통적인 자바 방식) : 단계별 명령

---
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
---
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

---

## 왜 중요한가?
- Java 8 이후 **람다, 스트림, Optional** 등이 도입되면서 함수형 프로그래밍은 자바의 표준 스타일이 됨
- 코드가 **간결**, **가독성 향상**
- **병렬 처리 및 데이터 파이프라인 처리에 효과적**

---

## 정리
함수형 프로그래밍은
- **함수를 1급 객체로 다루고**\
- **부수 효과를 최소화**하며\
- **선언형 스타일**을 지향하는 프로그래밍 패러다임이다.

>자바에서는 **람다, 함수형 인터페이스, 스트림** 등을 통해 함수형 프로그래밍 스타일을 지원한다.
---
## 자바에서 함수형 프로그래밍을 위한 도구

- **익명 클래스(Anonymous Class)** : 함수형 스타일 도입 전의 대안
- **람다식(Lambda Expression)** : 함수 자체를 값으로 다루는 간결한 문법
- **함수형 인터페이스(Functional Interface)** : `@FunctionalInterface` 어노테이션으로 단일 추상 메서드만 가진 인터페이스
-  **스트림 API(Stream API)** : 컬렉션 데이터를 선언적·함수형 스타일로  처리

## 상세 정리
### Anonymous Class

### Lambda

### Functional Interface

### Stream



```java
```