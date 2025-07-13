# 2025-07-08 TIL

## contents
- java 실행구조 이해하기
- javac(java Compiler) & java 명령어 
- 패키지 구조에서 컴파일

---
## java 실행구조 이해
- .java → **javac(Java Compiler) → .class** → java 실행
- JVM은 **.class 파일을 읽어 실행**
- main() 메서드가 진입점
- javac & java 명령어
    ```shell
    javac Hello.java  # 컴파일 (Hello.java → Hello.class)    
    ls  # Hello.class Hello.java
    java Hello  # 실행 (클래스명만 사용, 확장자 제거)
    # Hello, JAVA!
    ```
- 패키지 구조에서 컴파일
    ```shell
    javac -d out src/com/example/App.java
    ls  # Hello.class Hello.java  out   src
    ls -R out
    #  com
    #  out/com:
    #  example
    #  out/com/example:
    #  App.class
    java -cp out com.example.App
    # Hello from package!
    ```
- javac -d out src/com/example/App.java
  - App.java 파일을 컴파일할 때, 
  - **내부에 package com.example; 선언이 있으므로**
  - 자바 컴파일러는 패키지 구조대로 폴더를 만들어서 .class 파일을 저장함
  - -d out 옵션 덕분에 out/ 폴더 아래에 com/example/App.class 생성됨


- java -cp out com.example.App 
  - java
    - 자바 실행기 (JVM) 를 구동하는 명령어
    - .class 파일을 **메모리에 올려**서 실행시킴
    - .java 소스 파일은 못 돌림 .class만 가능
  - cp out 
    - -cp = --classpath: 클래스패스 설정 옵션
  - com.example.App
    - 실행할 클래스의 풀 클래스 이름 (FQCN: Fully Qualified Class Name)
    - JVM 이 FQCN을 자동으로 파일시스템 경로로 변환함. 그 과정에서 .class 도 붙음

📁 java-daily-commit/0-week-build-bootcamp/0-1-manual-compile/    <br>
├── src/com/example/App.java       ← 소스 파일  <br>
├── out/com/example/App.class      ← 컴파일 후  <br>

