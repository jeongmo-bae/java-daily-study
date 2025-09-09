package mission1.controller;

import javax.management.RuntimeErrorException;

import mission1.domain.Student;
import mission1.repository.StudentRepository;
import mission1.repository.MemoryStudentRepository;
import mission1.service.StudentService;

import java.util.Scanner;

public class Main {
    private static final String menu = """
            =====================
            학생 성적 관리 프로그램
            1. 학생 추가
            2. 학생 목록 조회
            3. 학생 검색 (학번)
            4. 학생 수정 (점수 변경)
            5. 학생 삭제
            6. 프로그램 종료
            =====================
            선택 : """;
    private StudentService studentService = new StudentService();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print(Main.menu);
            System.out.print("메뉴 번호를 입력하세요: ");
            String input = sc.nextLine();
            try {
                int selectedMenu = Integer.parseInt(input.trim());
                if(selectedMenu==1){

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

        Student student = new Student();
        StudentRepository studentRepository = new MemoryStudentRepository();
        try {
            studentRepository.save(student);        
        } catch (Exception e) {
            // TODO: handle exception
            if (e.getMessage()=="E0001"){
                System.out.println("이미 등록되어있는 학번입니다.");
            }else {
                throw new RuntimeException("Unknown Error");
            }
        }

        
    }
}
