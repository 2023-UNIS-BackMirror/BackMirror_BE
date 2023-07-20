package backmirror.backend.domain.famous.dto.response;

import backmirror.backend.domain.famous.vo.FamousFailBriefInfoVo;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class FamousFailListResponse {

    private List<FamousFailBriefInfoVo> famousFailBriefInfoVos;

    @Builder
    private FamousFailListResponse(List<FamousFailBriefInfoVo> famousFailBriefInfoVos) {
        this.famousFailBriefInfoVos = famousFailBriefInfoVos;
    }

    public static FamousFailListResponse from(List<FamousFailBriefInfoVo> famousFailBriefInfoVos) {
        return FamousFailListResponse.builder()
                .famousFailBriefInfoVos(famousFailBriefInfoVos)
                .build();
    }
}
