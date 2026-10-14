package ra.edu.api.service;

import ra.edu.api.dto.InstructorCreateRequest;
import ra.edu.api.model.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> findAllInstructors();
    Instructor findInstructorById(Long id);
    Instructor createInstructor(InstructorCreateRequest req);
}