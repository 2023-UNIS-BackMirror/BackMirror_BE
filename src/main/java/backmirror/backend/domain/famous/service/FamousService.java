package backmirror.backend.domain.famous.service;

import backmirror.backend.domain.famous.domain.Famous;
import backmirror.backend.domain.famous.dto.response.FamousFailListResponse;
import backmirror.backend.domain.famous.dto.response.FamousFailResponse;
import backmirror.backend.domain.famous.helper.FamousHelper;
import backmirror.backend.domain.famous.mapper.FamousMapper;
import backmirror.backend.domain.famous.repository.FamousRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FamousService {

    private final FamousRepository famousRepository;
    private final FamousMapper famousMapper;
    private final FamousHelper famousHelper;

    @Transactional
    public FamousFailListResponse getFailList() {
        List<Famous> famousFailList = famousRepository.findAll();
        return famousMapper.toFamousFailList(famousFailList);
    }

    @Transactional
    public FamousFailResponse getFail(Long famousId) {
        return famousMapper.toFamousFail(famousHelper.findById(famousId));
    }
}
