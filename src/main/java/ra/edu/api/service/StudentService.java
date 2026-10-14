package ra.edu.api.service;

import ra.edu.api.dto.StudentCreateRequest;

public interface StudentService {
    void createStudent(StudentCreateRequest req);
}