# 2025-07-21 TIL

## Primitive
- 원시 타입 자료형(primitive data type)
- **값 자체**를 저장
- 객체가 아님, **stack 영역에 저장** / **null 값 불가** 
- 자바 언어가 JVM 레벨에서 직접 지원하는 타입 (8개)
- byte, short, int, long, float, double, char, boolean
- **문자열(string)이 없음** (wrapper class 사용해야함)
- wrapper class 있음: int → Integer, boolean → Boolean 등
- 기본형끼리는 연산 가능하고 빠르지만, 객체가 아니기 때문에 메서드 사용 불가

| 타입      | 크기                | 기본값      | 범위 / 설명                            | Wrapper 클래스     |
|-----------|---------------------|-------------|------------------------------------|---------------------|
| `byte`    | 1 byte (8bit)       | `0`         | 아주 작은 정수 (`-128 ~ 127`)            | `Byte`              |
| `short`   | 2 byte              | `0`         | 작은 정수 (`-32,768 ~ 32,767`)         | `Short`             |
| `int`     | 4 byte              | `0`         | 일반적인 정수형 (자주 사용됨)                  | `Integer`           |
| `long`    | 8 byte              | `0L`        | 아주 큰 정수                            | `Long`              |
| `float`   | 4 byte              | `0.0f`      | 소수점 있는 숫자 (정밀도 낮음) , f 붙여야함(3.14f) | `Float`             |
| `double`  | 8 byte              | `0.0d`      | 소수점 숫자 (정밀도 높음, 기본 실수형)            | `Double`            |
| `char`    | 2 byte (UTF-16)     | `'\u0000'`  | 문자 1개 (작은따옴표 사용)                   | `Character`         |
| `boolean` | 1 bit *(1 byte JVM)*| `false`     | `true` 또는 `false`                  | `Boolean`           |

### char
- char는 항상 문자 하나만 가능 ('A', '1', '#', '가' 등)
- 내부적으로는 UTF-16 코드 단위(2바이트) 정수로 저장됨
- 참고로, '' 가 char , ""가 String 임
- 정수처럼 연산도 가능 ('A' + 1 → 'B')
```java
char ch1 = 'A';
char ch2 = 65;     // ASCII 코드 65 = 'A'
char ch3 = '\u0041'; // 유니코드 방식 ('A')
```

## wrapper class
- Wrapper 클래스는 java.lang 패키지에 존재함 (import 없이 사용 가능)
- int ↔ Integer 같은 변환은 자동으로 autoboxing / unboxing 됨
- 자바의 List, Map 등은 객체(Reference type)만 다룸 → int 대신 Integer 사용
- boxing / unboxing 은 필요하지 않다면 명식적으로 할 필요 없음(AutoBoxing/Unboxing)
- 박싱과 언박싱은 필요할 때만, 자바의 암시적 기능에 맡기자. 불필요한 명시적 Boxing/Unboxing은 가독성과 성능 모두에 좋지 않다.”
```java
    System.out.printf("나이: %d, 성적: %s(%.2f)\n", wrapperAge.intValue(), wrapperGrade.charValue(), wrapperScore.doubleValue());
```
