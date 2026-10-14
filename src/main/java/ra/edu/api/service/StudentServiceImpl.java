package ra.edu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.api.dto.StudentCreateRequest;
import ra.edu.api.model.Student;
import ra.edu.api.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(StudentCreateRequest req) {
        Student student = new Student();
        student.setName(req.getName());
        studentRepository.save(student);
    }
}