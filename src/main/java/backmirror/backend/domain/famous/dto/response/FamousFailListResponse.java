package backmirror.backend.domain.famous.dto.response;

import backmirror.backend.domain.famous.vo.FamousFailInfoVo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class FamousFailListResponse {

    private List<FamousFailInfoVo> famousFailInfoVos;

    @Builder
    private FamousFailListResponse(List<FamousFailInfoVo> famousFailInfoVos) {
        this.famousFailInfoVos = famousFailInfoVos;
    }

    public static FamousFailListResponse from(List<FamousFailInfoVo> famousFailInfoVos) {
        return FamousFailListResponse.builder()
                .famousFailInfoVos(famousFailInfoVos)
                .build();
    }
}
