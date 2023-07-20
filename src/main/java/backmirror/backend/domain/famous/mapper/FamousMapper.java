package backmirror.backend.domain.famous.mapper;

import backmirror.backend.domain.famous.domain.Famous;
import backmirror.backend.domain.famous.dto.response.FamousFailListResponse;
import backmirror.backend.domain.famous.dto.response.FamousFailResponse;
import backmirror.backend.domain.famous.vo.FamousFailBriefInfoVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FamousMapper {

    public FamousFailListResponse toFamousFailList(List<Famous> famousFailList) {
        List<FamousFailBriefInfoVo> famousFailBriefInfoVos = famousFailList.stream()
                .map(FamousFailBriefInfoVo::from)
                .toList();
        return FamousFailListResponse.from(famousFailBriefInfoVos);
    }

    public FamousFailResponse toFamousFail(Famous famous) {
        return FamousFailResponse.from(famous);
    }
}
