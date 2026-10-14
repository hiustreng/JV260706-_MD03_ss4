package ra.edu.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.api.dto.ApiResponse;
import ra.edu.api.dto.CourseCreateRequest;
import ra.edu.api.dto.CourseUpdateRequest;
import ra.edu.api.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> createCourse(@RequestBody CourseCreateRequest request) {
        courseService.createCourse(request);
        return new ResponseEntity<>(new ApiResponse<>("Course Created Successfully", true, null), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> updateCourse(@PathVariable Long id, @RequestBody CourseUpdateRequest request) {
        courseService.updateCourse(id, request);
        return ResponseEntity.ok(new ApiResponse<>("Course Updated Successfully", true, null));
    }
}