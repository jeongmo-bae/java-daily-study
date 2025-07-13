# 2025-07-13 TIL

## contents
- 외부 라이브러리 수동 적용 (의존성 지옥 체험)
  - 외부 라이브러리(gson)를 직접 다운로드하고, .jar 파일을 클래스패스에 수동 추가해서 사용해보기
  -  https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/
- ClassNotFoundException 등 전형적인 의존성 오류를 체험하고 이해하기
- 자바에서 외부 .jar 파일을 컴파일/실행 시 어떻게 참조하는지 학습
```text
0-3-gson-manual/
├── lib/                       # 외부 jar 보관용 디렉토리
│   └── gson-2.10.1.jar
├── src/
│   └── com/example/JsonDemo.java
├── out/                      # 컴파일 결과 클래스 저장
```

## ref
```shell
# -cp 옵션 : classpath 지정 
javac -cp "lib/gson-2.10.1.jar" -d out src/com/example/JsonDemo.java
# 실행 
java -cp "lib/gson-2.10.1.jar:out" com.example.JsonDemo 
# 패키징
jar cfe JsonDemo.jar com.example.JsonDemo -C out .
```
- jar 파일 실행하면 에러남 
  - jungmo@jungmo-ubuntu:~/Desktop/wd/jeongmo-bae/java-daily-study/0-week-build-bootcamp/0-3-gson-manual$ java -jar JsonDemo.jar
    Exception in thread "main" java.lang.NoClassDefFoundError: com/google/gson/Gson
- com.example.JsonDemo 에서 Gson 임포트시 루트경로 문제인가?? 
  ```java
  package com.example;
  import com.google.gson.Gson;
  // ~~~
  ```
  ```shell
  jar tf lib/gson-2.10.1.jar
  #~~~
  #META-INF/maven/
  #META-INF/maven/com.google.code.gson/
  #META-INF/maven/com.google.code.gson/gson/
  #com/google/gson/JsonStreamParser.class
  #com/google/gson/Gson$FutureTypeAdapter.class
  #com/google/gson/Gson.class
  #~~~
  ```
  - 아냐 classpath 잘 지정해줬으니 문제될거 없음...  왜 이러지??
  - **자 이게 중요해** 
    - javac -cp "lib/gson-2.10.1.jar" ...
      <br>이건 "컴파일할 때 Gson 클래스(위치 줄테니) 참조 가능하게 해줘"라는 뜻이고,
      <br>JsonDemo.class 안에는 단지 Gson을 import했다는 흔적만 있음
      <br>Gson.class 자체가 포함되는 건 아님 
    - jar cfe JsonDemo.jar com.example.JsonDemo -C out . <br>
      이 명령은 단지 out/ 디렉토리 안의 .class 파일들만 묶음
      <br>즉, 외부 라이브러리(gson-2.10.1.jar)는 포함되지 않음!
    - 결국 fat jar 를 만들어 주거나, manifest.txt 를 직접 만들어 줘야함.
      - manifest.txt 생성
      ```vbnet
      Main-Class: com.example.JsonDemo
      Class-Path: lib/gson-2.10.1.jar
  
      ```
      ```shell
      # m: 사용자 정의 manifest.txt 사용 -> 기존 META-INF/MANIFEST.MF에 덮어 씌워짐 
      jar cfm JsonDemo.jar manifest.txt -C out .
      ```
    - Fat Jar 만들기 (gson.class도 포함시킴)
      - 모든 .class 파일 + 외부 라이브러리 내용까지 몽땅 jar에 포함하는 방식
      ```shell
      mkdir tmp
      cd tmp
  
      # 1. 우리 클래스들 복사
      jar xf ../JsonDemo.jar
  
      # 2. gson 클래스들 추출
      jar xf ../lib/gson-2.10.1.jar
  
      # 3. fat jar 만들기
      jar cfe ../JsonDemo-fat.jar com.example.JsonDemo *
      ```
## 이걸 매 외부 라이브러리를 쓸 때 마다, 해줄 수 없잖아? -> 빌드 도구가 그래서 필요한거야!! (의존성!)
