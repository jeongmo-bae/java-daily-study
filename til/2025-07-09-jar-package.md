# 2025-07-09 TIL

## contents
- .class 파일을 JAR(Java ARchive) 로 패키징하기
- 명령어 사용법 익히기 (cfe, cvf, tf, xf)
- IFEST.MF 파일의 역할 이해 
- java -jar로 실행 실습
---

## 기본 개념
- JAR : 여러 개의 .class, 이미지, 설정 파일 등을 묶은 ZIP 기반 압축 파일
- jar 명령어 : JDK에 포함된, JAR 파일 생성 및 조회/압축 해제 도구
- MANIFEST.MF : JAR 파일 내부에 포함되는 **메타정보** 파일
- Main-Class : java -jar 실행 시 진입점을 지정하는 속성
---

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
java -jar hello.jar # 출력: Hello, JAR!
```
- cfe: create + specify entrypoint(Main-Class)
- C out .: out 디렉토리 기준으로 JAR 내용 압축
