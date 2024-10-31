package com.itb.sms.service.impl;

import com.itb.sms.dto.RoomTypeDto;
import com.itb.sms.mapper.RoomTypeMapper;
import com.itb.sms.model.RoomTypeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.RoomTypeRepository;
import com.itb.sms.service.RoomTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    private final RoomTypeMapper roomMapper;
    private final RoomTypeRepository roomRepository;

    public RoomTypeServiceImpl(RoomTypeMapper roomMapper, RoomTypeRepository roomRepository) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomTypeDto getById(Long id) {
        Optional<RoomTypeInfo> entity = roomRepository.findById(id);

        return roomMapper.map(entity.get());

    }


    @Override
    public List<RoomTypeDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return roomMapper.mapList(roomRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return roomMapper.mapList(roomRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(RoomTypeDto dto) {


            roomRepository.save(roomMapper.map(dto));

    }


}
