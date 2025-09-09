package mission1.controller;

import javax.management.RuntimeErrorException;

import mission1.domain.Student;
import mission1.repository.StudentRepository;
import mission1.repository.MemoryStudentRepository;

public class Main {
    public static void main(String[] args) {
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
