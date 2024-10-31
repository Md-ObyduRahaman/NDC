package com.itb.sms.service.impl;

import com.itb.sms.dto.QuotaDto;
import com.itb.sms.mapper.QuotaMapper;
import com.itb.sms.model.QuotaInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.QuotaRepository;
import com.itb.sms.service.QuotaService;
import com.itb.sms.service.QuotaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuotaServiceImpl implements QuotaService {

    private final QuotaMapper quotaMapper;
    private final QuotaRepository quotaRepository;

    public QuotaServiceImpl(QuotaMapper quotaMapper, QuotaRepository quotaRepository) {
        this.quotaMapper = quotaMapper;
        this.quotaRepository = quotaRepository;
    }

    @Override
    public QuotaDto getById(Long id) {
        Optional<QuotaInfo> entity = quotaRepository.findById(id);

        return quotaMapper.map(entity.get());

    }


    @Override
    public List<QuotaDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return quotaMapper.mapList(quotaRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return quotaMapper.mapList(quotaRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(QuotaDto dto) {


            quotaRepository.save(quotaMapper.map(dto));

    }


}
