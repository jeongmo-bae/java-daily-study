package theme4_collection_framework.quiz;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Student student1 =  new Student("유재석",new ArrayList<>());
        student1.setLicense(new String[] {"python","java","C","C#"});

        Student student2 =  new Student("배정모",new ArrayList<>());
        student2.setLicense(new String[] {"python","python","JAVA","java"});

        Student student3 =  new Student("정형돈",new ArrayList<>());
        student3.setLicense(new String[] {"python"});

        System.out.println(student1.getName() + " : " + student1.getLicense());
        System.out.println(student2.getName() + " : " + student2.getLicense());
        System.out.println(student3.getName() + " : " + student3.getLicense());
        System.out.println("===============================================");
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        Iterator<Student> iterator = studentList.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            if (student.getLicense().contains("java")){
                System.out.println(student.getName());
            }
        }

    }
}
