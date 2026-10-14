package ra.edu.api.service;

import ra.edu.api.dto.CourseCreateRequest;
import ra.edu.api.dto.CourseUpdateRequest;

public interface CourseService {
    void createCourse(CourseCreateRequest req);
    void updateCourse(Long id, CourseUpdateRequest req);
}