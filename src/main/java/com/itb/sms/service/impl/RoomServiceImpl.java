package com.itb.sms.service.impl;

import com.itb.sms.dto.RoomDto;
import com.itb.sms.mapper.RoomMapper;
import com.itb.sms.model.RoomInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.RoomRepository;
import com.itb.sms.service.RoomService;
import com.itb.sms.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomMapper roomMapper;
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomMapper roomMapper, RoomRepository roomRepository) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomDto getById(Long id) {
        Optional<RoomInfo> entity = roomRepository.findById(id);

        return roomMapper.map(entity.get());

    }


    @Override
    public List<RoomDto> findAll(UserInfo user,String status, String deleted) {
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
    public void saveOrUpdate(RoomDto dto) {


            roomRepository.save(roomMapper.map(dto));

    }


}
