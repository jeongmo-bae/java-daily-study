package mission1.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import mission1.domain.Student;

public class MemoryStudentRepository implements StudentRepository{
    private static Map<String, Student> storage = new HashMap<>();

    @Override
    public void save(Student student) {
        MemoryStudentRepository.storage.put(student.getId(), student);
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }
    @Override
    public void update(String id, int koreanScore, int englishScore , int mathScore) {
        storage.get(id).setKoreanScore(koreanScore);
        storage.get(id).setEnglishScore(englishScore);
        storage.get(id).setMathScore(mathScore);
    }

    @Override
    public List<Student> findByAll(){
        List<Student> studentList = new ArrayList<>();
        studentList = storage.values().stream().toList() ;
        return studentList;
    }

    @Override
    public Optional<Student> findById(String id){
        Optional<Student> optional = Optional.ofNullable(storage.get(id));
        return optional;
    }
}
