package ra.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.api.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    // Không cần viết thêm phương thức, kế thừa toàn bộ CRUD: findById, findAll, save, delete...
}