package exception.ex0ref;

import java.util.Scanner;

import static util.MyLogger.log;

public class MainV0Ref {
    public static void main(String[] args)  {
        NetworkServiceV0Ref networkService = new NetworkServiceV0Ref();

        Scanner scanner = new Scanner(System.in);
        while(true){
            log("전송할 문자 : ");
            String input = scanner.nextLine();
            if (input.equals("exit")){
                break;
            }
            networkService.sendMessage(input);
            System.out.println();
        }
        log("프로그램을 정상 종료합니다.");


    }
}
