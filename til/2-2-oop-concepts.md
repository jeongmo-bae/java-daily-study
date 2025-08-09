# 2025-08-09 TIL

## OOP 핵심 개념

| 구분 | 개념 | 정의 | 목적 | 키워드 |
|------|------|------|------|--------|
| **4대 핵심** | **상속**<br>(Inheritance) | 부모 클래스의 속성과 메서드를 자식 클래스가 물려받음 | 코드 재사용, 계층 구조 | `extends`, `super` |
|  | **캡슐화**<br>(Encapsulation) | 데이터와 메서드를 하나로 묶고, 외부 접근을 제한 | 정보 은닉, 데이터 무결성 | `private`, Getter/Setter |
|  | **다형성**<br>(Polymorphism) | 같은 인터페이스나 부모를 공유하는 객체가 다른 방식으로 동작 | 유연성, 확장성 | 오버라이딩, 업캐스팅 |
|  | **추상화**<br>(Abstraction) | 복잡한 내부 구현을 숨기고 필수 정보만 노출 | 단순화, 역할 중심 설계 | `interface`, `abstract` |
| **심화 개념** | **합성**<br>(Composition) | 다른 객체를 필드로 포함해 기능을 위임 | 결합도↓, 유연성↑ | `has-a` 관계 |
|  | **의존성 역전**<br>(Dependency Inversion) | 상위 모듈이 하위 모듈 구현에 의존하지 않음 | 느슨한 결합, 교체 용이 | DIP, IoC/DI |
|  | **SOLID 원칙** | 객체지향 5대 설계 원칙 | 유지보수성, 확장성 | SRP, OCP, LSP, ISP, DIP |
|  | **불변 객체**<br>(Immutable Object) | 상태를 변경할 수 없는 객체 | 안전성, 스레드 안정성 | `final`, 무상태 |
|  | **다형성 확장** | 오버로딩·제네릭·패턴 활용 | 다형성 범위 확장 | 제네릭, 전략 패턴 |
|  | **추상화 심화** | 템플릿 메서드, Sealed Class | 계층 통제, 부분 구현 | `sealed`, `default` 메서드 |

---

## 핵심 개념 상세

### 1. **상속(Inheritance)**
- **정의**: 부모 클래스의 속성과 메서드를 자식 클래스가 물려받아 사용.
- **목적**: 코드 재사용, 계층 구조 형성.
- **주의**: 남용 시 결합도 증가 → 유지보수 어려움.

```java
class Animal {
    void sound() { System.out.println("Some sound"); }
}
class Dog extends Animal {
    @Override void sound() { System.out.println("Bark"); }
}
Animal a = new Dog();
a.sound(); // Bark
```

---

### 2. **캡슐화(Encapsulation)**
- **정의**: 객체의 상태(필드)와 동작(메서드)을 하나로 묶고, 외부에 꼭 필요한 것만 공개. 접근제어자(private, protected, public)로 접근 범위 제한.
- **목적**: 데이터 보호, 무결성 유지.
- **방법**: `private` 필드, `public` 메서드(getter/setter)로 접근.

```java
class User {
    private String name;
    public String getName() { return name; }
    public void setName(String name) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException();
        this.name = name;
    }
}
```

---

### 3. **다형성(Polymorphism)**
- **정의**: 같은 메시지를 보내도 객체에 따라 다른 방식으로 동작.
- **종류**:  
  - 오버라이딩(런타임 다형성)  
  - 오버로딩(컴파일 타임 다형성)
- **장점**: 코드 확장·변경 시 호출부 수정 최소화.

```java
class Camera { void take() { System.out.println("사진 찍기"); } }
class SpeedCam extends Camera { @Override void take() { System.out.println("과속 사진 찍기"); } }

Camera cam = new SpeedCam(); // 업캐스팅
cam.take(); // 과속 사진 찍기
```

---

### 4. **추상화(Abstraction)**
- **정의**: 핵심 동작만 정의하고 세부 구현은 숨김.
- **방법**: 인터페이스, 추상 클래스.
- **목적**: 구현 교체 용이, 역할 중심 설계.

```java
interface Payment {
    void pay(int amount);
}
class CardPayment implements Payment {
    public void pay(int amount) { System.out.println(amount + "원 카드 결제"); }
}
```

---

## 심화 개념 상세

### 5. **합성(Composition)**
- **정의**: 다른 객체를 필드로 가지고 기능을 위임.
- **장점**: 런타임에 조합 변경 가능, 상속보다 유연.

```java
class Engine { void run() { System.out.println("엔진 구동"); } }
class Car {
    private Engine engine;
    Car(Engine engine) { this.engine = engine; }
    void drive() { engine.run(); }
}
```

---

### 6. **의존성 역전(DIP) & 인터페이스 중심 설계**
- **정의**: 상위 모듈이 하위 구현에 의존하지 않게 설계.
- **방법**: 인터페이스 + DI 컨테이너 활용.

```java
interface Storage { void save(String data); }
class FileStorage implements Storage { public void save(String data) { /* 파일 저장 */ } }
class App {
    private Storage storage;
    App(Storage storage) { this.storage = storage; }
}
```

---

### 7. **SOLID 원칙**
- **SRP**: 클래스는 하나의 책임만.
- **OCP**: 확장엔 열려 있고 변경엔 닫혀야.
- **LSP**: 부모 객체 대신 자식 객체 사용 가능해야.
- **ISP**: 인터페이스는 작게 쪼개기.
- **DIP**: 고수준 모듈은 저수준 모듈 구현에 의존하지 않기.

---

### 8. **불변 객체(Immutable Object)**
- **정의**: 상태 변경 불가.
- **장점**: 스레드 안전, 예측 가능.
- **방법**: `final` 필드, setter 없음.

```java
final class Money {
    private final int amount;
    public Money(int amount) { this.amount = amount; }
    public Money add(int value) { return new Money(this.amount + value); }
}
```

---

### 9. **다형성 확장**
- 오버로딩, 제네릭, 전략 패턴 활용으로 범위 확장.

```java
static <T> void printList(List<T> list) {
    for (T item : list) System.out.println(item);
}
```

---

### 10. **추상화 심화**
- 템플릿 메서드 패턴, Sealed Class 등 계층 통제.

```java
abstract class Report {
    public final void generate() {
        header();
        body();
        footer();
    }
    protected abstract void body();
    private void header() { System.out.println("Header"); }
    private void footer() { System.out.println("Footer"); }
}
```

---
