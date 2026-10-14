package ra.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.api.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}