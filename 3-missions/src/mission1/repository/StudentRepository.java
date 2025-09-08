package mission1.repository;

import mission1.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void save(Student student);
    void delete(Student student);
    List<Student> findByAll();
    Optional<Student> findByName(String name);
}
