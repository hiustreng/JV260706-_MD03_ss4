package ra.edu.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.api.model.Course;
import ra.edu.api.model.Student;
import ra.edu.api.model.StudentEnrollment;
import ra.edu.api.repository.CourseRepository;
import ra.edu.api.repository.StudentEnrollmentRepository;
import ra.edu.api.repository.StudentRepository;

@Service
public class StudentEnrollmentServiceImpl implements StudentEnrollmentService {

    private final StudentEnrollmentRepository studentEnrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentEnrollmentServiceImpl(StudentEnrollmentRepository studentEnrollmentRepository,
                                        StudentRepository studentRepository,
                                        CourseRepository courseRepository) {
        this.studentEnrollmentRepository = studentEnrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));

        StudentEnrollment enrollment = new StudentEnrollment(student, course);
        studentEnrollmentRepository.save(enrollment);
    }
}