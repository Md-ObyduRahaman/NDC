package com.itb.sms.service.impl;

import com.itb.sms.dto.BranchDto;
import com.itb.sms.mapper.BranchMapper;
import com.itb.sms.model.BranchInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.BranchRepository;
import com.itb.sms.service.BranchService;
import com.itb.sms.service.BranchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchMapper branchMapper;
    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchMapper branchMapper, BranchRepository branchRepository) {
        this.branchMapper = branchMapper;
        this.branchRepository = branchRepository;
    }

    @Override
    public BranchDto getById(Long id) {
        Optional<BranchInfo> entity = branchRepository.findById(id);

        return branchMapper.map(entity.get());

    }


    @Override
    public List<BranchDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return branchMapper.mapList(branchRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return branchMapper.mapList(branchRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public Integer saveOrUpdate(BranchDto dto) {

        try {
            branchRepository.save(branchMapper.map(dto));
            return 1;
        } catch (Exception ex) {

            return -1;
        }
    }


}
