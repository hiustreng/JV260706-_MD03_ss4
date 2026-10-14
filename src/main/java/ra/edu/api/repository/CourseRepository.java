package ra.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.api.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}