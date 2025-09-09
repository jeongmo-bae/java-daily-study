package mission1.service;

import mission1.domain.Student;
import mission1.repository.MemoryStudentRepository;
import mission1.repository.StudentRepository;

public class StudentService {
    StudentRepository studentRepository ;
    public StudentService(MemoryStudentRepository memoryStudentRepository){
        this.studentRepository = memoryStudentRepository;
    }

    public void addStudent(Student student){
        if (studentRepository.findById(student.getId()).isPresent()){

        }
    }
}
