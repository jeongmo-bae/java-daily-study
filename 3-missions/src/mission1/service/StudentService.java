package mission1.service;

import mission1.domain.Student;
import mission1.repository.MemoryStudentRepository;
import mission1.repository.StudentRepository;
import java.util.Optional;

public class StudentService {
    private StudentRepository studentRepository ;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    private void validateDuplication(Student student){
        studentRepository.findById(student.getId()).ifPresent(m->{
            throw new RuntimeException("이미 존재하는 학번입니다.");
        });
    }

    public void addStudent(Student student){
        validateDuplication(student);
        studentRepository.save(student);
        System.out.println("[학생 등록 완료] ID : " + student.getId() + ", Name : " + student.getName());
    }
    
}
