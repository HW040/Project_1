package green.project_1.project.ProjectReq;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProjectReq {

    private ProjectDetails project;

    @Getter
    @Setter
    public static class ProjectDetails {
        private String name;                // 프로젝트명
        private Long writerUserNo;          // 작성자 사용자 번호
        private String description;         // 프로젝트 설명
        private List<ProjectMember> memberList;  // 프로젝트 멤버 리스트
        private String startAt;             // 프로젝트 시작일
        private String createdAt;           // 프로젝트 생성 날짜
        private String deadLine;            // 프로젝트 종료일
    }

    @Getter
    @Setter
    public static class ProjectMember {
        private Long userNo;  // 멤버 사용자 번호
    }
}
