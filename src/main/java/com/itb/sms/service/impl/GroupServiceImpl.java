package com.itb.sms.service.impl;

import com.itb.sms.dto.GroupDto;
import com.itb.sms.mapper.GroupMapper;
import com.itb.sms.model.GroupInfo;
import com.itb.sms.repository.GroupRepository;
import com.itb.sms.service.GroupService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupMapper groupMapper;
    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupMapper groupMapper, GroupRepository groupRepository) {
        this.groupMapper = groupMapper;
        this.groupRepository = groupRepository;
    }

    @Override
    public GroupDto getById(Long id) {
        Optional<GroupInfo> entity = groupRepository.findById(id);

        return groupMapper.map(entity.get());

    }


    @Override
    public List<GroupDto> findAll(String status, String deleted) {


            return groupMapper.mapList(groupRepository.findAll().stream()
                    .filter(info ->(status ==null || info.getStatus().equals(status))
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));


    }

    @Override
    public void saveOrUpdate(GroupDto dto) {


        groupRepository.save(groupMapper.map(dto));

    }


}
