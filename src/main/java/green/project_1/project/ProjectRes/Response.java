package green.project_1.project.ProjectRes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private String code;      // 상태 코드 (200, 400 등)
    private String message; // 응답 메시지 (OK, 입력을 확인해주세요 등)


    public Response(int code, String message) {
        this.code = String.valueOf(code);
        this.message = message;
    }
}