package green.project_1.project;

import green.project_1.User.UserMapper;
import green.project_1.project.ProjectReq.ProjectDeleteReq;
import green.project_1.project.ProjectReq.ProjectReq;
import green.project_1.project.ProjectRes.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor  // Lombok 어노테이션으로 생성자 주입 처리
public class ProjectController {
    private final UserMapper Usermapper;

    private final ProjectService projectService;  // final 필드로 선언
    private long projectNo;


    @PostMapping
    public Response createProject(@RequestBody ProjectReq request) {
        return projectService.createProject(request);
    }
    // 프로젝트 삭제
    @DeleteMapping("/{projectNo}") // 프로젝트 번호를 경로에 포함시켜서 삭제
    public ResponseEntity<Response> deleteProject(@RequestBody ProjectDeleteReq request) {
        Long signedUserNo = request.getSignedUserNo();  // 요청에서 사용자 번호 (signedUserNo) 가져오기

        // 프로젝트 번호로 리더 번호 가져오기
        long leaderNo = Usermapper.leaderNo(projectNo);  // 리더 번호 조회

        // 프로젝트 mapper을 통해서 프로젝트 가져온다



        // 로그인한 사용자의 번호가 리더와 일치하는지 확인
        if (signedUserNo != leaderNo) {
            // 리더가 아니면 403 Forbidden 상태 코드 반환
            return ResponseEntity.status(403).body(new Response(403, "프로젝트 리더만 이 프로젝트를 삭제할 수 있습니다."));
        }

        // 서비스에서 프로젝트 삭제 처리 (프로젝트 삭제 로직 구현)
        Response response = deleteProjectLogic(request, projectNo);  // 실제 삭제 로직 호출

        // 서비스 응답 반환
        return ResponseEntity.status(response.getCode()).body(response);
    }

    // 실제 프로젝트 삭제 로직
    private Response deleteProjectLogic(ProjectDeleteReq request, Long projectNo) {
        // 삭제할 프로젝트가 존재하는지 확인
        // 프로젝트 삭제 처리 (예: DB에서 프로젝트 삭제)
        // 프로젝트가 존재하면 삭제하고, 존재하지 않으면 404 반환
        // 예시로 성공 메시지 반환
        return new Response(200, "프로젝트 삭제 되었습니다.");
    }
}