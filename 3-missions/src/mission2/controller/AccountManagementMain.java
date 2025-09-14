package mission2.controller;

import mission2.repository.AccountRepository;
import mission2.repository.MemoryAccountRepository;
import mission2.service.AccountService;

import java.awt.*;
import java.util.Scanner;

public class AccountManagementMain {
    private static final String MENU = """
            =============================
               은행 계좌 관리 프로그램
            =============================
            1. 계좌 개설
            2. 입금
            3. 출금
            4. 잔액 조회
            5. 전체 계좌 조회
            0. 종료
            메뉴 선택 : """;
    public static void main(String[] args) {
        AccountRepository accountRepository = new MemoryAccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(AccountManagementMain.MENU);
            String input = scanner.nextLine().trim();
            StringBuffer sbInput = new StringBuffer();
            try {
                if (input.equals("1")) {
                    System.out.println("[계좌 개설]");
                    System.out.println("계좌 번호 : ");
                    sbInput.append(scanner.nextLine().trim()+";");
                    System.out.println("예금주 : ");
                    sbInput.append(scanner.nextLine().trim()+";");
                    System.out.println("초기입금액 : ");
                    sbInput.append(scanner.nextLine().trim());
                    System.out.println(
                            accountService.makeAccount(
                                    sbInput.toString().split(";")[0]
                                    ,sbInput.toString().split(";")[1]
                                    ,Long.parseLong(sbInput.toString().split(";")[2])
                            )
                    );
                } else if (input.equals("2")) {

                } else if (input.equals("3")) {

                } else if (input.equals("4")) {

                } else if (input.equals("5")) {
                    System.out.println(accountService.findAllAccounts());
                } else if (input.equals("0")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.");
                }
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
