package exception.ex1;

import exception.ex1.NetworkServiceV1_1;

import java.util.Scanner;

import static util.MyLogger.log;

public class MainV1 {
    public static void main(String[] args) throws Exception {
        NetworkServiceV1_1 networkService = new NetworkServiceV1_1();

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
