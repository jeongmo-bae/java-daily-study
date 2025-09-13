package mission1.repository;

import mission1.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void save(Student student);
    void delete(String id);
    void update(String id,int koreanScore, int englishScore, int mathScore);
    List<Student> findByAll();
    Optional<Student> findById(String id);
}
