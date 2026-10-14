package ra.edu.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.api.dto.ApiResponse;
import ra.edu.api.dto.StudentCreateRequest;
import ra.edu.api.dto.StudentEnrollmentRequest;
import ra.edu.api.service.StudentEnrollmentService;
import ra.edu.api.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentEnrollmentService studentEnrollmentService;

    @Autowired
    public StudentController(StudentService studentService, StudentEnrollmentService studentEnrollmentService) {
        this.studentService = studentService;
        this.studentEnrollmentService = studentEnrollmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> createStudent(@RequestBody StudentCreateRequest request) {
        studentService.createStudent(request);
        return new ResponseEntity<>(new ApiResponse<>("Student Created Successfully", true, null), HttpStatus.OK);
    }

    @PostMapping("/enrollments")
    public ResponseEntity<ApiResponse<Object>> enrollStudent(@RequestBody StudentEnrollmentRequest request) {
        studentEnrollmentService.enrollStudent(request.getStudentId(), request.getCourseId());
        return ResponseEntity.ok(new ApiResponse<>("Student Enrolled Successfully", true, null));
    }
}