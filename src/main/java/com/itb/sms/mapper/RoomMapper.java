package com.itb.sms.mapper;


import com.itb.sms.dto.RoomDto;
import com.itb.sms.model.BuildingInfo;
import com.itb.sms.model.RoomInfo;
import com.itb.sms.model.RoomTypeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.BuildingRepository;
import com.itb.sms.repository.RoomTypeRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RoomMapper {


    private final UserService userService;
    private final BuildingRepository buildingRepository;
    private final RoomTypeRepository roomTypeRepository;

    public RoomMapper(UserService userService,BuildingRepository buildingRepository,RoomTypeRepository roomTypeRepository) {
        this.userService = userService;
        this. buildingRepository = buildingRepository ;
        this.roomTypeRepository = roomTypeRepository;
    }


    public RoomInfo map(RoomDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        RoomInfo entity = new RoomInfo();
        entity.setId(dto.getId());
        entity.setRoomName(dto.getRoomName());
        Optional<RoomTypeInfo> typeInfo=roomTypeRepository.findById(dto.getTypeId());
        if(typeInfo.isPresent()){
            entity.setTypeInfo(typeInfo.get());
        }else {

                new Exception("Type is not exist with id " + dto.getTypeId());
            }

        Optional<BuildingInfo> buildingInfo=buildingRepository.findById(dto.getBuildingId());
        if(buildingInfo.isPresent()){
            entity.setBuildingInfo(buildingInfo.get());
        }else {

            new Exception("Building is not exist with id " + dto.getTypeId());
        }

        entity.setRemarks(dto.getRemarks());
        entity.setNoOfSeat(dto.getNoOfSeat());
        entity.setAcStatus(dto.getAcStatus());
        entity.setStatus(dto.getStatus());
        entity.setDeleted(dto.getDeleted());
        entity.setInstituteId(userInfo.getInstituteId());
        entity.setBranchId(userInfo.getBranchId());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<RoomDto> mapList(List<RoomInfo> entities) {
        List<RoomDto> list = new ArrayList<>();

        RoomDto dto;

        for (RoomInfo entity : entities) {

            dto = new RoomDto();
            dto.setId(entity.getId());
            dto.setRoomName(entity.getRoomName());
            dto.setTypeId(entity.getTypeInfo().getId());
            dto.setTypeName(entity.getTypeInfo().getTypeName());
            dto.setBuildingId(entity.getBuildingInfo().getId());
            dto.setBuildingName(entity.getBuildingInfo().getBuildingName());
            dto.setAcStatus(entity.getAcStatus());
            dto.setRemarks(entity.getRemarks());
            dto.setNoOfSeat(entity.getNoOfSeat());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public RoomDto map(RoomInfo entity) {

        RoomDto dto = new RoomDto();

        dto.setId(entity.getId());
        dto.setRoomName(entity.getRoomName());
        dto.setTypeId(entity.getTypeInfo().getId());
        dto.setTypeName(entity.getTypeInfo().getTypeName());
        dto.setBuildingId(entity.getBuildingInfo().getId());
        dto.setBuildingName(entity.getBuildingInfo().getBuildingName());
        dto.setAcStatus(entity.getAcStatus());
        dto.setRemarks(entity.getRemarks());
        dto.setNoOfSeat(entity.getNoOfSeat());
        dto.setStatus(entity.getStatus());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());
        dto.setDeleted(entity.getDeleted());


        return dto;


    }
}
