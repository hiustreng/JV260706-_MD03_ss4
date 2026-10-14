package ra.edu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.api.dto.ApiResponse;
import ra.edu.api.dto.InstructorCreateRequest;
import ra.edu.api.model.Instructor;
import ra.edu.api.service.InstructorService;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody InstructorCreateRequest request) {
        Instructor instructor = instructorService.createInstructor(request);
        return new ResponseEntity<>(new ApiResponse<>("Ok", true, instructor), HttpStatus.CREATED);
    }
}