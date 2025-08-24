# 2025-08-24 TIL

## Exception Level
```mermaid
%%{init: {
  "flowchart": { "curve": "linear" },
  "theme": "base",
  "themeVariables": { "fontSize": "20px" }
}}%%

graph TD
    O[Object]:::root
    O -- ROOT --> T[Throwable]:::throwable
    T -- THROWABLE --> E[Error]:::error
    T -- THROWABLE --> X[Exception]:::exception

    E -- ERROR --> E1[OutOfMemoryError]:::error
    E -- ERROR --> E2[StackOverflowError]:::error
    E -- ERROR --> E3[VirtualMachineError]:::error

    X -- EXCEPTION --> R[RuntimeException]:::runtime
    R -- RUNTIME --> R1[NullPointerException]:::runtime
    R -- RUNTIME --> R2[ArrayIndexOutOfBoundsException]:::runtime
    R -- RUNTIME --> R3[ClassCastException]:::runtime
    R -- RUNTIME --> R4[IllegalArgumentException]:::runtime
    R -- RUNTIME --> R5[NumberFormatException]:::runtime
    R -- RUNTIME --> R6[ArithmeticException]:::runtime

    X -- EXCEPTION --> C[Checked Exceptions]:::checked
    C -- CHECKED --> C1[IOException]:::checked
    C -- CHECKED --> C2[SQLException]:::checked
    C -- CHECKED --> C3[ClassNotFoundException]:::checked
    C -- CHECKED --> C4[InterruptedException]:::checked
    C -- CHECKED --> C5[FileNotFoundException]:::checked

%% 스타일 정의 (파스텔톤)
    classDef root fill:#cbd5e1,stroke:#334155,color:#0f172a;
    classDef throwable fill:#d1fae5,stroke:#10b981,color:#064e3b;
    classDef error fill:#fecaca,stroke:#f87171,color:#7f1d1d;
    classDef exception fill:#fde68a,stroke:#fbbf24,color:#78350f;
    classDef runtime fill:#fef3c7,stroke:#f59e0b,color:#7c2d12;
    classDef checked fill:#bae6fd,stroke:#38bdf8,color:#0c4a6e;

%% 간선 색상 (출발지 카테고리 색에 맞춤)
    linkStyle 0 stroke:#10b981,stroke-width:2px;   %% Object -> Throwable
    linkStyle 1 stroke:#f87171,stroke-width:2px;   %% Throwable -> Error
    linkStyle 2 stroke:#fbbf24,stroke-width:2px;   %% Throwable -> Exception
    linkStyle 3,4,5 stroke:#f87171,stroke-width:2px;    %% Error -> 자식들
    linkStyle 6 stroke:#f59e0b,stroke-width:2px;   %% Exception -> RuntimeException
    linkStyle 7,8,9,10,11,12 stroke:#f59e0b,stroke-width:2px; %% RuntimeException -> 자식들
    linkStyle 13 stroke:#38bdf8,stroke-width:2px;  %% Exception -> Checked Exceptions
    linkStyle 14,15,16,17,18 stroke:#38bdf8,stroke-width:2px; %% Checked -> 자식들
```
### 0. Object 
- 모든 객체의 부모 

### 1. **Throwable (최상위)**
- 모든 예외와 오류의 최상위 클래스.

### 2. **Error (에러 계층)**
- 개발자가 잡지 않는 **심각한 문제들**.
- **예시**
  - `OutOfMemoryError` : 메모리 부족
  - `StackOverflowError` : 무한 재귀로 인한 스택 초과
  - `VirtualMachineError` : JVM 내부 오류

### 3. **Exception (예외 계층)**

#### (1) Checked Exception
- **컴파일 시점에 반드시 처리해야 하는 예외**
- **대표 예시**
  - `IOException`
  - `SQLException`
  - `ClassNotFoundException`
  - `InterruptedException`

#### (2) RuntimeException (Unchecked Exception)
- **실행 중에만 발생하는 예외**
- `try-catch`로 처리하지 않아도 **컴파일 가능**
- **대표 예시**
  - `NullPointerException`
  - `ArrayIndexOutOfBoundsException`
  - `ClassCastException`
  - `IllegalArgumentException`
  - `NumberFormatException`
  - `ArithmeticException`

## Exception Handling
- throw : 예외 발생시키기
- throws : 발생시킨 예외를 메서드 밖으로 던지는 것
- RuntimeException 은 throws 안잡아도 돼. -> 컴파일러가 안잡으니까(Unchecked)
  - 대신 개발자가 놓칠 순 있겠지.

### 기본 규칙(try - catch / throws)
- 예외는 잡아서 처리하거나 밖으로 던져야 한다
- 예외를 잡거나 던질때 지정한 예외 + 자식 예외도 함께 가능 (polymorphism)
> 예외를 처리 안하고, 계속 던지면? -> main() 밖으로 예외를 던지면, 예외 로그를 출력하면서 시스템 종료



