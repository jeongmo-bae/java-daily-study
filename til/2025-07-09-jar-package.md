# 2025-07-09 TIL

## contents
- .class 파일을 JAR(Java ARchive) 로 패키징하기
- 명령어 사용법 익히기 (cfe, cvf, tf, xf)
- IFEST.MF 파일의 역할 이해 
- java -jar로 실행 실습

## 기본 개념
- JAR : 여러 개의 .class, 이미지, 설정 파일 등을 묶은 ZIP 기반 압축 파일
- jar 명령어 : JDK에 포함된, JAR 파일 생성 및 조회/압축 해제 도구
- MANIFEST.MF : JAR 파일 내부에 포함되는 **메타정보** 파일
- Main-Class : java -jar 실행 시 진입점을 지정하는 속성

## JAR 파일 만들기
```text
java-daily-study/
└── 0-week-build-bootcamp/
    └── 0-2-jar-package/
        ├── src/
        │   └── com/example/App.java
```
```shell
javac -d out src/com/example/App.java 
jar cfe hello.jar com.example.App -C out .
ls  # hello.jar out       src

java -jar hello.jar # 출력: Hello, JAR!
java -cp out com.example.App  # Hello, JAR!

jar tf hello.jar  # jar 압축파일 내용 확인
#META-INF/
#META-INF/MANIFEST.MF
#com/
#com/example/
#com/example/App.class

jar xf hello.jar  # 압축풀기
```

## 명령어
- jar cfe hello.jar com.example.App -C out .
    - jar : Java의 압축 유틸 (ZIP 기반 JAR 만들기)
    - c : create, JAR 파일을 새로 생성 
    - f : file, JAR의 이름을 지정 (뒤에 hello.jar)
    - e : entrypoint, Main-Class 를 지정 (뒤에 com.example.App)
    - com.example.App : 프로그램 진입점 (main 메서드 가진 클래스, 패키지 포함)
    - -C out . : out/ 디렉토리 안의 (.)모든 파일을 JAR에 포함
> 패키지 구조를 유지한 상태로 압축하려면 반드시 -C out . 같이 써줘야 함.

- jar tf / jar xf 
  - t : table, JAR 내부 목록만 출력 (jar tf hello.jar)
  - x : extract, 압축 해제 (jar xf hello.jar)
  - v : verbose, 자세한 출력 (파일명 나열) (jar cvf ...)

- java -jar : JAR 내부의 MANIFEST.MF 파일에 Main-Class 항목이 있어야 실행 가능
  - Main-Class → java -jar 실행 시 찾을 메인 클래스 지정
  - 위치는 항상 META-INF/MANIFEST.MF
  ```text
  Manifest-Version: 1.0
  Created-By: 17.0.11 (Oracle Corporation)
  Main-Class: com.example.App
  ```

## 정리
- JAR은 ZIP 기반의 Java 배포 포맷이다. jar cfe 옵션으로 실행 진입점 지정 가능하며, Main-Class를 명시하지 않으면 java -jar 실행 불가하다.
