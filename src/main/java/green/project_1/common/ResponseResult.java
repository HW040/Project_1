package green.project_1.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Builder
@AllArgsConstructor
public class ResponseResult {
    @Schema(title = "상태 코드")
    private int code;
    @Schema(title = "결과 메세지")
    private String message;

    @ResponseStatus(HttpStatus.OK)
    public static ResponseResult success(String message) {
        return new ResponseResult(200, message);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public static ResponseResult serverError() {
        return new ResponseResult(500, "서버 에러");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static ResponseResult badRequest(String message) {
        return new ResponseResult(400, message);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    public static ResponseResult noPermission() {
        return new ResponseResult(403, "권한 없음");
    }
}
