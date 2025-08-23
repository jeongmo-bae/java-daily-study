# 2025-08-23 TIL

## Thread
- start() : 스레드를 실행하는 특별한 메서드 -> run() 메서드를 실행함
- hread 는 순서와 실행기간을 보장하지 않는다! -> multiThread

### User Thread(Non-demon Thread)
- 모든 User Thread 가 종료되면 JVM 종료, 즉 Main Thread 가 대기
### Demon Thread
- 백그라운드에서 실행
- 모든 User Thread 가 종료되면, Demon Thread 는 자동종료
- JVM 은 Demon Thread 의 실행 완료를 대기 X 
```java
instanceOfThread.setDaemon(true);
```
> Java Program은 Main Thread 가 아닌, 모든 User Thread 가 종료되면 종료된다.

## Runnable
- Interface
- java.lang
- Runnable Interface 를 활용하여 스레드를 사용하는게 권장
  - (다중 상속 불가)Thread 를 상속받으면 다른 클래스 상속이 안돼
  - 여러 스레드가 동일한 Runnable 을 공유가능하지 = 자원관리 효율(스레드 객체 계속만들 필요가없잖아)
  - 실행할 작업과 스레드를 분리해 가독성 up
- Nested Class 를 사용하면 더 편하게 만들 수 있다
    - lambda expression 쓰면 매우 편함

## Thread Info
```java
// main thread
Thread mainThread = Thread.currentThread();
log("mainThread = " + mainThread);
log("mainThread.getId() = " + mainThread.getId());
log("mainThread.getName() = " + mainThread.getName());
log("mainThread.getPriority() = " + mainThread.getPriority()); // 기본이 5
log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup());
log("mainThread.getState = " + mainThread.getState());

log("===============================================");

// myThread thread
Thread myThread = new Thread(new HelloRunnable(),"myThread");
log("myThread = " + myThread);
log("myThread.getId() = " + myThread.getId());
log("myThread.getName() = " + myThread.getName());
log("myThread.getPriority() = " + myThread.getPriority()); // 기본이 5
log("myThread.getThreadGroup() = " + myThread.getThreadGroup());
log("myThread.getState = " + myThread.getState());

//20:40:56.397 [     main] mainThread = Thread[main,5,main]
//20:40:56.404 [     main] mainThread.getId() = 1
//20:40:56.404 [     main] mainThread.getName() = main
//20:40:56.406 [     main] mainThread.getPriority() = 5
//20:40:56.406 [     main] mainThread.getThreadGroup() = java.lang.ThreadGroup[name=main,maxpri=10]
//20:40:56.406 [     main] mainThread.getState = RUNNABLE
//20:44:54.038 [     main] ===============================================
//20:44:54.038 [     main] myThread = Thread[myThread,5,main]
//20:44:54.038 [     main] myThread.getId() = 15
//20:44:54.038 [     main] myThread.getName() = myThread
//20:44:54.039 [     main] myThread.getPriority() = 5
//20:44:54.039 [     main] myThread.getThreadGroup() = java.lang.ThreadGroup[name=main,maxpri=10]
//20:44:54.039 [     main] myThread.getState = NEW
```
- getPriority() : 
  - 스레드의 우선순위를 반환
  - 1 이 가장 낮고, 5 가 기본, 10 이 제일 높음
  - **setPriority()** 로 변경 가능
  - 스레드 스케줄러가 어떤 스레드를 우선적으로 실행할지 결정하는데 사용됨!(**hint**)
  - **BUT! 실제 실행 순서는 JVM 구현과 OS 에 따라 달라질 수 있음**
- getThreadGroup() : 
  - 스레드가 속한 스레드 그룹을 반환하는 메서드
  - **스레드 그룹은 스레드를 그룹화하여 관리할 수 있는 기능 제공**
  - 기본적으로 모든 스레드는 **부모 스레드**와 동일한 스레드그룹에 속함
  - **Parent Thread** : A thread which creates another new Thread!!
  - main 스레드는 기본으로 제공되는 **mainThreadGroup**에 소속되어있음. 위의 myThread 도 이 그룹이겠지!!
    ```java
    java.lang.ThreadGroup[name=main,maxpri=10]
    ```
  - ThreadGroup 기능은 직접적으로 사용할 일이 거의 없음
- getState() : 
  - 스레드의 현재 상태 반환. 반환 값은 **Thread.State 열거형**에 정의된 상수 중 하나
  - 반환 값
    - NEW : 스레드가 아직 시작되지 않은 상태(생성만)
    - RUNNABLE : 스레드가 실행중 or 실행될 준비가 된 상태
    - BLOCKED : 스레드가 **동기화 락**을 기다리는 상태(Synchronized)
    - WAITING : 스레드가 다른 스레드의 특정 작업 완료 대기
    - TIMED_WAITING : 일정 시간 동안 기다리는 상태(Thread.sleep())
    - TERMINATED : 스레드가 실행을 마친 상태

## Thread LifeCycle
- NEW - RUNNABLE - ( BLOCKED | WAITING | TIMED_WAITING ) - TERMINATED
- BLOCKED , WAITING , TIMED_WAITING 은 CPU 실행 스케줄러에 들어가지 않음(CPU 사용 안함!!!)
- RUNNABLE 만이 CPU 사용하는 상태

### NEW
- 스레드가 생성되고 아직 시작되지 않은 상태
- start() 메서드가 호출되지 않은 상태

### RUNNABLE
- 스레드가 실행될 준비가 된 상태(모두 동시에 실행되는건 아니니까)
- 실제로 CPU에서 실행 될 수 있지
- start()메서드가 호출 되면 이 상태로 들어감
- 즉, OS 스케줄러의 실행 대기열 혹은 CPU 에서 실제 실행중인 상태

### BLOCKED
- 스레드가 다른 스레드에 의해 **동기화 락**을 얻기 위해 대기하는 상태
- synchronized 블록에 진입하기 위해 락을 얻어야 하는 경우!(요 상태)
  - 현재는 다른 스레드가 락을 획득한 상태인거지

### WAITING
- 스레드가 다른 스레드의 특정 작업 완료 대기 상태
- wait() , join() 메서드가 호출될 때
- 다른 스레드가 notify(), notifyAll() 메서드를 호출하거나, join()이 완료될때까지 기다림

### TIMED_WAITING
- 스레드가 특정 시간동안 다른 스레드의 작업 완료 대기
- sleep(long millis), wait(long timeout), join(long mills)
- 주어진 시간이 경과하거나 **다른 스레드가 해당 스레드를 깨우면** 이 상태를 벗어남

### TERMINATED
- 종료(정상 종료 / 예외 발생 종료)
- 스레드는 한 번 종료되면 다시 시작할 수 없음

### 상태 전이 과정
- NEW > RUNNABLE
- RUNNABLE > BLOCKED / WAITING / TIMED_WAITING
- BLOCKED / WAITING / TIMED_WAITING > RUNNABLE
- RUNNABLE > TERMINATED

```java
package theme7_thread.thread.control;

import theme7_thread.thread.start.HelloRunnable;
import static util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            log("start");
            log("myThread.state2 = " + Thread.currentThread().getState());
            try {
                log("sleep start");
                Thread.sleep(2000);
                log("sleep end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log("end");
        },"myThread");
        log("myThread.state1 = " + thread.getState());
        log("myThread.start()");
        thread.start();
        for (int i = 0; i < 10; i++) {
            if(thread.getState() == Thread.State.TERMINATED){
                log("myThread.state4 = " + thread.getState());
                log("myThread END");
                break;
            } else if (thread.getState() == Thread.State.RUNNABLE) {
                Thread.sleep(1000);
            } else{
                log("myThread.state3 = " + thread.getState());
                Thread.sleep(2000);
            }
        }
    }
}
//21:51:06.844 [     main] myThread.state1 = NEW
//21:51:06.846 [     main] myThread.start()
//21:51:06.846 [ myThread] start
//21:51:06.846 [ myThread] myThread.state2 = RUNNABLE
//21:51:06.846 [ myThread] sleep start
//21:51:07.852 [     main] myThread.state3 = TIMED_WAITING
//21:51:08.852 [ myThread] sleep end
//21:51:08.853 [ myThread] end
//21:51:09.858 [     main] myThread.state4 = TERMINATED
//21:51:09.859 [     main] myThread END
```