package ra.edu.api.dto;

public class StudentCreateRequest {
    private String name;

    public StudentCreateRequest() {
    }

    public StudentCreateRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}