package mission1.controller;

import javax.management.RuntimeErrorException;

import mission1.domain.Student;
import mission1.repository.StudentRepository;
import mission1.repository.MemoryStudentRepository;
import mission1.service.StudentService;

import java.util.Scanner;

public class Main {
    private static final String MENU =
        "=====================\n" +
        "학생 성적 관리 프로그램\n" +
        "1. 학생 추가\n" +
        "2. 학생 목록 조회\n" +
        "3. 학생 검색 (학번)\n" +
        "4. 학생 수정 (점수 변경)\n" +
        "5. 학생 삭제\n" +
        "6. 프로그램 종료\n" +
        "=====================\n" +
        "선택 : ";
    private StudentRepository studentRepository = new MemoryStudentRepository();
    private StudentService studentService = new StudentService(studentRepository);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print(Main.MENU);
            String input = sc.nextLine();
            try {
                int selectedMenu = Integer.parseInt(input.trim());
                if(selectedMenu==1){
                    studentService.addStudent(new Student());
                } else if (selectedMenu==2) {
                    
                } else if (selectedMenu==3) {
                    
                } else if (selectedMenu==4) {
                    
                } else if (selectedMenu==5) {
                    
                } else if(selectedMenu==6){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println("잘못된 입력 입니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력 입니다.");
            }
        }
        sc.close();
    }
}
