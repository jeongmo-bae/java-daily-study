package mission1.service;

import mission1.domain.Student;
import mission1.repository.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository ;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void validateDuplication(String id){
        studentRepository.findById(id).ifPresent(m->{
            throw new RuntimeException("이미 존재하는 학번입니다.");
        });
    }

    public void validateExistence(String id){
        if(studentRepository.findById(id).isEmpty()){
            throw new RuntimeException("해당 학번의 학생이 없습니다.");
        }
    }
    public void validateScore(int score){
        if(score < 0 | score > 100){
            throw new RuntimeException("0~100 사이 값을 입력해 주세요");
        }
    }

    public void addStudent(String id, String name, int koreanScore, int englishScore, int mathScore){
        validateDuplication(id);
        validateScore(koreanScore);
        validateScore(englishScore);
        validateScore(mathScore);
        Student student = new Student(id, name, koreanScore,englishScore,mathScore);
        studentRepository.save(student);
    }
    public void getStudentList(){
        for(Student student : studentRepository.findByAll()){
            System.out.printf(
                    "%-8s %-8s %-8d %-8d %-8d %-8d %-8.1f\n",
                    student.getId(),
                    student.getName(),
                    student.getKoreanScore(),
                    student.getEnglishScore(),
                    student.getMathScore(),
                    student.getTotalScore(),
                    student.getAverageScore());
        }
    }
    public void searchStudent(String id){
        validateExistence(id);
        Student student = studentRepository.findById(id).get();
        System.out.println("ID      : " + student.getId());
        System.out.println("NAME    : " + student.getName());
        System.out.println("KOR     : " + student.getKoreanScore());
        System.out.println("ENG     : " + student.getEnglishScore());
        System.out.println("MATH    : " + student.getMathScore());
        System.out.println("TOTAL   : " + student.getTotalScore());
        System.out.println("AVERAGE : " + student.getAverageScore());
    }
    public void modifyStudentScoreInfo(String id,int koreanScore, int englishScore, int mathScore){
        validateExistence(id);
        validateScore(koreanScore);
        validateScore(englishScore);
        validateScore(mathScore);
        studentRepository.update(id,koreanScore,englishScore,mathScore);
    }
    public void deleteStudentInfo(String id){
        validateExistence(id);
        studentRepository.delete(id);
    }

}
