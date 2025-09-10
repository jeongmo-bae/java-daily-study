package mission1.repository;

import java.security.KeyStore.Entry;
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
        storage.put(student.getId(), student);
    }

    @Override
    public void delete(String id) {
        if(storage.containsKey(id)){
            storage.remove(id);
        }else {

        }
    }
    @Override
    public void update(String id) {

    }

    @Override
    public List<Student> findByAll(){
        List<Student> studentList = new ArrayList<>();
        for (Map.Entry<String,Student> entry : storage.entrySet()) {
            studentList.add(entry.getValue());
        }
        return studentList;
    }

    @Override
    public Optional<Student> findById(String id){
        Optional<Student> optional = Optional.ofNullable(storage.get(id));
        return optional;
    }
}
