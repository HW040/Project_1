package green.project_1.project;

import green.project_1.project.ProjectReq.ProjectReq;  // ProjectReq import
import green.project_1.project.ProjectRes.Response;  // Response import
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    // 요청 데이터 -> 응답 메시지 변환
    public Response mapToResponse(ProjectReq request) {
        // 필수 값 검증
        if (request.getProject().getName() == null ||
                request.getProject().getWriterUserNo() == null ||
                request.getProject().getDescription() == null ||
                request.getProject().getStartAt() == null ||
                request.getProject().getCreatedAt() == null ||
                request.getProject().getDeadLine() == null) {
            return new Response(400, "입력을 확인해주세요.");
        }
        return new Response(200, "OK");
    }
}
