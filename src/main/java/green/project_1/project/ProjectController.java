package green.project_1.project;

import green.project_1.project.ProjectReq.ProjectReq;
import green.project_1.project.ProjectRes.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor  // Lombok 어노테이션으로 생성자 주입 처리
public class ProjectController {

    private final ProjectService projectService;  // final 필드로 선언

    @PostMapping
    public Response createProject(@RequestBody ProjectReq request) {
        return projectService.createProject(request);
    }
}