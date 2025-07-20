# 2025-07-20 TIL

## Contents
- Maven의 기본 개념과 작동 원리 이해
- Maven으로 Java 프로젝트 생성 & 실행
- pom.xml 구조 익히기
- Maven이 의존성을 어떻게 관리하는지 체험

## Maven
- 자바의 빌드 도구. 컴파일 → 테스트 → 패키징 전 과정을 자동화해줌
- pom.xml 
  - 프로젝트 설정 파일. 의존성, 플러그인, 빌드 정보 등을 선언형으로 작성
- Maven Central 
  - 공용 저장소. 필요한 라이브러리를 자동으로 다운로드 
- 라이프사이클 
  - compile, test, package, install, deploy 단계로 작업 정의
- 플러그인 
  - 컴파일, 패키징, 테스트 등 각 단계 실행 방법을 정의하는 도구

## Maven Project 생성
- IntelliJ 실행 → New Project 클릭
- 왼쪽에서 Maven 선택
- SDK는 Java 17로 선택 (없으면 오른쪽 + 눌러 추가)
- GroupId: com.example / ArtifactId: maven-demo

## pom.xml
- pom.xml은 Maven의 **Project Object Model** 파일로, 빌드, 의존성, 버전 등을 모두 선언하는 중심 설정 파일
- 0-5-maven-demo의 pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- XML 문서 선언 -->

<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <!-- Maven 프로젝트임을 선언하는 루트 요소 -->
  <!-- xmlns: 기본 네임스페이스 (필수) -->
  <!-- xsi: XML 스키마 설정 (형식 검사용) -->

  <modelVersion>4.0.0</modelVersion>
  <!-- POM 모델 버전. 항상 4.0.0 고정 -->

  <groupId>org.example</groupId>
  <!-- 프로젝트 소속 그룹 (보통 도메인 기반) -->

  <artifactId>0-5-maven-demo</artifactId>
  <!-- 프로젝트 이름 (JAR 이름 등으로 사용됨) -->

  <version>1.0-SNAPSHOT</version>
  <!-- 프로젝트 버전.
       SNAPSHOT은 개발 중 버전을 의미 -->

  <properties>
    <!-- Maven 컴파일러 설정 등 전역 속성 정의 -->

    <maven.compiler.source>17</maven.compiler.source>
    <!-- 소스코드의 Java 버전 (작성 기준 JDK) -->

    <maven.compiler.target>17</maven.compiler.target>
    <!-- 컴파일 결과의 Java 버전 (실행 대상 JDK) -->

    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <!-- 파일 인코딩 설정 (한글 깨짐 방지) -->
  </properties>

  <dependencies>
    <!-- 외부 라이브러리 의존성 선언 -->

    <dependency>
      <groupId>junit</groupId>
      <!-- 라이브러리 그룹 (여기서는 junit 프로젝트) -->

      <artifactId>junit</artifactId>
      <!-- 사용할 라이브러리 이름 -->

      <version>4.13.2</version>
      <!-- 사용할 버전 (JUnit 4의 최신 안정 버전) -->

      <scope>test</scope>
      <!-- 이 의존성은 test 범위에서만 사용됨
           (컴파일/실행에는 포함 안 됨) -->
    </dependency>
  </dependencies>
</project>
```
- Maven은 외부 라이브러리를 가져올 때 좌표 기반으로 가져옴
  - <groupId>:<artifactId>:<version>
  - groupId: 그 라이브러리를 만든 조직 이름 (보통 도메인 기반, 여기선 junit)
  - artifactId: 실제 라이브러리 이름 (여기선 junit)
- **scope**
  - compile : 기본값. 어디서든 사용 가능 (main, test 둘 다)
  - provided : 컴파일 시 필요하지만 런타임엔 환경에서 제공 (예: Servlet API)
  - runtime : 런타임엔 필요하지만 컴파일엔 불필요
  - test : 테스트 코드에서만 사용 (JUnit, Mockito 등)
  - Maven이 디렉터리 구조와 scope를 연동해 해석함
  - test scope 은 src/test/java 를 테스트 디렉터리로 인식함, 커스텀 테스트 디렉터리가 필요하면 아래 추가 필요
```xml
<build>
    <testSourceDirectory>src/test2/java</testSourceDirectory>
</build>
```
