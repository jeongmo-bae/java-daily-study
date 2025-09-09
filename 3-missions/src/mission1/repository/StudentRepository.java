package mission1.repository;

import mission1.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void save(Student student) throws Exception;
    void delete(Student student) throws Exception;
    List<Student> findByAll();
    Optional<Student> findByName(String name) throws Exception;
}
