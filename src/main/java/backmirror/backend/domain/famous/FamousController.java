package backmirror.backend.domain.famous;

import backmirror.backend.domain.famous.dto.response.FamousFailListResponse;
import backmirror.backend.domain.famous.dto.response.FamousFailResponse;
import backmirror.backend.domain.famous.service.FamousService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/famous")
@Tag(name = "Famous")
public class FamousController {

    private final FamousService famousService;

    @Operation(summary = "유명인 실패 사례 목록 보기")
    @GetMapping
    public FamousFailListResponse getFailList() {
        return famousService.getFailList();
    }

    @Operation(summary = "유명인 실패 사례 하나 보기")
    @GetMapping("/{famousId}")
    public FamousFailResponse getFail(
            @PathVariable(name = "famousId") Long famousId
    ) {
        return famousService.getFail(famousId);
    }
}
