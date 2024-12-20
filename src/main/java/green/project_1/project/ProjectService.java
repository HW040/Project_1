package green.project_1.project;

import green.project_1.project.ProjectReq.ProjectReq;       // ProjectReq import
import green.project_1.project.ProjectRes.Response;       // Response import
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private static List<ProjectReq.ProjectDetails> projectList = new ArrayList<>();  // 임시 메모리 저장소

    // 프로젝트 생성
    public Response createProject(ProjectReq request) {
        // 필수 값 검증 (누락된 값이 있으면 에러 반환)
        if (request == null || request.getProject() == null ||
                request.getProject().getName() == null ||
                request.getProject().getWriterUserNo() == null ||
                request.getProject().getDescription() == null ||
                request.getProject().getStartAt() == null ||
                request.getProject().getCreatedAt() == null ||
                request.getProject().getDeadLine() == null) {
            return new Response(400, "입력을 확인해주세요.");
        }

        // 프로젝트 정보를 임시 리스트에 저장
        projectList.add(request.getProject());

        // 성공 응답 반환
        return new Response(200, "OK");
    }
}