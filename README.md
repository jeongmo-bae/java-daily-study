# ☕️ Java Daily Study (With ChatGPT)

> **시작일:** 2025-07-08  
> **목표:** 자바 기초 → 스프링 백엔드 → 배포 
> **참고 자료:** ChatGPT로 Q&A, 코드, 피드백

## 🛠️ 사용 도구

- Java 17
- Gradle (빌드 시스템)
- IntelliJ IDEA (IDE)
- Git & GitHub (버전 관리)

## 🛠️ D-1 : 환경 준비

| 작업 | 설명                                             |
|------|------------------------------------------------|
| GitHub 저장소 | 예: `java-daily-study`                          |
| IntelliJ + JDK 17 | 통일된 실습 환경                                      |
| Gradle  | -                                              |

## ✅ 커밋 컨벤션

- `feat`: 기능 추가
- `fix`: 버그 수정
- `docs`: 문서 작성
- `refactor`: 리팩토링
- `test`: 테스트 코드 작성
- `chore`: 기타 설정 변경
- `ci`: CI 설정 관련 변경


## 로드맵 (총 13 주)

### 🏗️ **0주차 – Build Tool Bootcamp** (Gradle & Maven 기초)

> “빌드가 뭐야?”에서 시작해 Gradle·Maven 양대 도구의 **필수 개념 + 실습**을 하루씩 맛본다.  
> 모든 내용은 ChatGPT와 대화하며 **실패 → 수정 → 이해** 흐름으로 진행!

| Day | 주제 | 실습 & 커밋 예시 | ChatGPT 활용 프롬프트 |
|-----|------|-----------------|-----------------------|
| 0-1 | **수동 컴파일**<br>`javac`, `java`, 클래스패스 | `feat: compile hello manually` | “javac로 패키지 구조 컴파일 순서 알려줘” |
| 0-2 | **JAR 만들기**<br>`jar cfe …`, `MANIFEST.MF` | `feat: package first jar` | “jar 파일 구조와 Class-Path 속성 설명해줘” |
| 0-3 | **의존성 지옥 체험**<br>외부 lib(gson) 수동 복사 | `test: gson manual demo` | “ClassNotFoundException 원인과 해결?” |
| 0-4 | **빌드 도구 WHY**<br>Ant → Maven → Gradle 역사 | `docs: why-build-tools.md` | “Maven이 Ant보다 나은 점 3가지 알려줘” |
| 0-5 | **Maven 10분 컷**<br>`mvn archetype:generate`, POM 구조 | `chore: init maven app` | “Maven scope compile·provided 차이?” |
| 0-6 | **Gradle 10분 컷**<br>`gradle init`, `build.gradle` DSL | `chore: init gradle app` | “Gradle task graph 시각화 방법 알려줘” |
| 0-7 | **Maven vs Gradle 비교 & 정리**<br>속도, DSL, 멀티모듈 | `docs: maven-vs-gradle.md` | “멀티모듈을 두 도구로 설정할 때 차이?” |

> 🔑 **핵심 개념 체크리스트**
> - Build = _Compile + Test + Package (+ Deploy)_
> - **Classpath** 와 **Dependency 관리** 차이 이해
> - Maven의 **POM(선언형)** ↔ Gradle의 **DSL(선언+스크립트)**
> - 멀티모듈 프로젝트 구조와 의존성 흐름 (parent-child / settings.gradle)

### 1-4주차 — Java & CS 기초

| 주차 | 핵심 목표 | 내용(예시 미션) |
|------|-----------|----------------|
| 1주 | Java 기본 문법·JVM | 변수/조건/반복, 구구단 |
| 2주 | 함수·배열·클래스 | ATM CLI |
| 3주 | OOP 4대 특성 | 도서관 시스템 v1 |
| 4주 | 예외·컬렉션·제네릭 | 도서관 v2 + JUnit |

### 5-6주차 — I/O · **Gradle·Maven 심화 & CI**

| 주차 | 목표 | 내용 |
|------|------|------|
| 5주 | 파일 I/O, Stream | CSV 성적 관리 앱 |
| 6주 | **빌드 자동화**<br>– Maven Surefire, Shade<br>– Gradle Jacoco, FatJar<br>– CI( GitHub Actions / Gitea ) | `ci: add build & test workflow` |

### 7-9주차 — Spring 입문 & REST API

| 주차 | 핵심 | 미션 |
|------|------|------|
| 7주 | Spring Core(IoC/DI) | HelloController |
| 8주 | Spring MVC & Validation | Todo REST API |
| 9주 | Spring Data JPA + MySQL(Docker) | Todo + DB + Testcontainers |

### 10-11주차 — 보안 · 배포

| 주차 | 주제 | 실습 |
|------|------|------|
| 10주 | Spring Security + JWT | 로그인 & 권한 |
| 11주 | Docker + Nginx + EC2 | 프로덕션 배포 스크립트 |

### 12주차 — 최종 프로젝트 & 회고

| 항목 | 내용 |
|------|------|
| 프로젝트 | 기능 보강 + 테스트 80 %↑ |
| 문서화 | README, ERD, API 명세 |
| 회고 | 마크다운 + 블로그 정리 |

## 기타 참고

- TIL 폴더는 매일 `YYYY-MM-DD.md` 형식으로 작성
- 필요시 `.md` 정리 파일이나 `docs/` 디렉토리 사용 가능
- 실제 서비스 수준의 미션은 `projects/` 안에서 독립 실행형으로 구성

---
