package mission1.controller;

import mission1.domain.Student;
import mission1.repository.MemoryStudentRepository;
import mission1.service.StudentService;

import java.util.Scanner;

public class Main {
    private static final String MENU = "=====================\n"
        + "학생 성적 관리 프로그램\n"
        + "1. 학생 추가\n"
        + "2. 학생 목록 조회\n"
        + "3. 학생 검색 (학번)\n"
        + "4. 학생 수정 (점수 변경)\n"
        + "5. 학생 삭제\n"
        + "6. 프로그램 종료\n"
        + "=====================\n"
        + "선택 : ";
        

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemoryStudentRepository memoryStudentRepository = new MemoryStudentRepository();
        StudentService studentService = new StudentService(memoryStudentRepository);
        while(true){
            System.out.print(Main.MENU);
            String input = sc.nextLine();
            try {
                int selectedMenu = Integer.parseInt(input.trim());
                if(selectedMenu==1){
                    System.out.print("학번 : ");
                    String id = sc.nextLine();
                    studentService.validateDuplication(id);
                    System.out.println("이름 : ");
                    String name = sc.nextLine();
                    System.out.println("국어점수 : ");
                    int koreanScore = Integer.parseInt(sc.nextLine().trim());
                    studentService.validateScore(koreanScore);
                    System.out.println("영어점수 : ");
                    int englishScore = Integer.parseInt(sc.nextLine().trim());
                    studentService.validateScore(englishScore);
                    System.out.println("수학점수 : ");
                    int mathScore = Integer.parseInt(sc.nextLine().trim());
                    studentService.validateScore(mathScore);
                    studentService.addStudent(id, name, koreanScore, englishScore, mathScore);
                    System.out.println("학생 등록이 완료되었습니다.");
                } else if (selectedMenu==2) {
                    System.out.println("학생 목록 : ");
                    System.out.printf(
                            "%-8s %-8s %-8s %-8s %-8s %-8s %-8s\n"
                            , "id", "name", "kor", "eng", "math", "total", "avg"
                    );
                    studentService.getStudentList();
                } else if (selectedMenu==3) {
                    System.out.println("검색할 학번 : ");
                    String id = sc.nextLine();
                    studentService.validateExistence(id);
                    studentService.searchStudent(id);
                } else if (selectedMenu==4) {
                    System.out.print("수정할 학번 : ");
                    String id = sc.nextLine();
                    studentService.validateExistence(id);
                    System.out.println("새 국어점수 : ");
                    int koreanScore = Integer.parseInt(sc.nextLine().trim());
                    studentService.validateScore(koreanScore);
                    System.out.println("새 영어점수 : ");
                    int englishScore = Integer.parseInt(sc.nextLine().trim());
                    studentService.validateScore(englishScore);
                    System.out.println("새 수학점수 : ");
                    int mathScore = Integer.parseInt(sc.nextLine().trim());
                    studentService.validateScore(mathScore);
                    studentService.modifyStudentScoreInfo(id,koreanScore,englishScore, mathScore);
                    System.out.println("학생 점수 수정 완료!");
                } else if (selectedMenu==5) {
                    System.out.print("삭제할 학번 : ");
                    String id = sc.nextLine();
                    studentService.validateExistence(id);
                    studentService.deleteStudentInfo(id);
                    System.out.println("학생 삭제 완료!");
                } else if(selectedMenu==6){
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println("잘못된 입력 입니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력 입니다.");
            } catch (RuntimeException e){
            System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
