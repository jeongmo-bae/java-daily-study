# 2025-07-20 TIL

## Contents
```java
import com.google.gson.Gson;

public class JsonDemo {
    public static void main(String[] args) {
        Gson gson = new Gson();
        System.out.println(gson.toJson("hello"));
    }
}
```
- gson-2.10.1.jar 파일을 구해서 lib/ 폴더에 수동으로 복사
- 컴파일할 때 매번 classpath 직접 명시, 실행도 매번 classpath 설정
```shell
javac -cp "lib/gson-2.10.1.jar" -d out src/com/example/JsonDemo.java
java -cp "out:lib/gson-2.10.1.jar" com.example.JsonDemo
```
- JAR로 묶고 실행하려고 하면 또 외부 JAR 못 찾음 → NoClassDefFoundError
  - manifest.txt 따로 만들고 다시 jar로 패키징해야 함…
```shell
echo "Main-Class: com.example.JsonDemo" > manifest.txt
echo "Class-Path: lib/gson-2.10.1.jar" >> manifest.txt
jar cfm JsonDemo.jar manifest.txt -C out/ .
```
- 문제점 요약:
  - 외부 라이브러리 관리 수동 (버전 바뀌면 또 고생)
  -	classpath 일일이 입력
  -	JAR 만들 때도 classpath 명시
  -	실행 시에도 classpath 명시
  -	실수하면 바로 ClassNotFoundException, NoClassDefFoundError
- 소스코드가 여러 파일이면? 더 지옥
```java
/*
src/
├── com/example/model/User.java
        └── com/example/Main.java
*/
//Main.java
import com.example.model.User;
public class Main {
    public static void main(String[] args) {
        User user = new User("Jungmo", 29);
        System.out.println(user);
    }
}
//User.java
package com.example.model;

public class User {
    private String name;
    private int age;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return name + " (" + age + ")";
    }
}
```
- build
    - 순서 틀리면 cannot find symbol 에러 남
```shell
javac -d out src/com/example/model/User.java src/com/example/Main.java
```

## 빌드 도구가 해결해주는 것

| 항목             | 수동 (전통 방식)                          | Maven / Gradle (빌드 도구)         |
|------------------|-------------------------------------------|------------------------------------|
| **의존성 관리**  | 외부 JAR 수동 다운로드 및 복사             | `dependencies` 블록에 한 줄 추가   |
| **컴파일**       | `javac` 명령 직접 입력                     | `mvn compile`, `gradle build`     |
| **테스트 실행**  | 테스트 클래스 직접 실행                    | `mvn test`, `gradle test` 자동 실행 |
| **JAR 패키징**   | `jar` 명령어로 수동 패키징                 | 명령 한 줄로 자동 패키징           |
| **클래스패스 설정** | 실행마다 `-cp` 옵션 직접 지정             | 자동으로 클래스패스 구성            |
| **멀티모듈 지원** | 직접 경로 지정 + 순서 고려해야 함           | 계층적 모듈 구성 및 의존성 선언 지원 |
| **재현성 있는 빌드** | OS마다 설정 달라 생기는 빌드 편차 존재   | 설정을 코드로 관리 → 동일한 결과 보장 |

> ✅ 빌드 도구는 **성컴파일 + 테스트 + 패키징 + 실행환경 구성까지 자동화**해서 개발자의 생산을 높여줌