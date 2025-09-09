package mission1.controller;

import javax.management.RuntimeErrorException;

import mission1.domain.Student;
import mission1.repository.StudentRepository;
import mission1.repository.MemoryStudentRepository;

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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print(Main.menu);
            int selectedMenu = sc.nextInt();



        }
        sc.close();

        Student student = new Student("0001","배정모",50,60,70);
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
