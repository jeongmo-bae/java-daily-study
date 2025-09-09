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
    public void save(Student student) throws Exception{
        if(!storage.containsKey(student.getId())){
            storage.put(student.getId(), student);
            System.out.println("ID : " + student.getId() + ", Name : " + student.getName() + "성적 등록 완료");
        }else{
            throw new Exception("E0001");
        }
    }

    @Override
    public void delete(String id) throws Exception {
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
