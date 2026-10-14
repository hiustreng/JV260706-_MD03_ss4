package ra.edu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.api.dto.InstructorCreateRequest;
import ra.edu.api.model.Instructor;
import ra.edu.api.repository.InstructorRepository;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> findAllInstructors() {
        // Sử dụng phương thức findAll() có sẵn của JpaRepository
        return instructorRepository.findAll();
    }

    @Override
    public Instructor findInstructorById(Long id) {
        // Sử dụng findById(id) trả về Optional, nếu không thấy thì ném RuntimeException
        return instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy giảng viên với ID: " + id));
    }

    @Override
    public Instructor createInstructor(InstructorCreateRequest req) {
        // Tạo đối tượng Instructor mới từ thông tin DTO (không set ID, JPA sẽ tự tăng)
        Instructor instructor = new Instructor();
        instructor.setName(req.getName());
        instructor.setEmail(req.getEmail());

        // Lưu vào database qua JpaRepository
        return instructorRepository.save(instructor);
    }
}