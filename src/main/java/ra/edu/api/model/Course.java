package ra.edu.api.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CourseStatus status;

    // Quan hệ N - 1: Khóa học liên kết với Giảng viên qua cột khóa ngoại instructor_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    // Quan hệ 1 - N: Khóa học có nhiều lượt đăng ký qua bảng trung gian
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentEnrollment> enrollments = new ArrayList<>();

    public Course() {
    }

    public Course(String title, CourseStatus status, Instructor instructor) {
        this.title = title;
        this.status = status;
        this.instructor = instructor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<StudentEnrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<StudentEnrollment> enrollments) {
        this.enrollments = enrollments;
    }
}