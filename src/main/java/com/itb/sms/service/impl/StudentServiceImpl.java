package com.itb.sms.service.impl;

import com.itb.sms.dto.StudentDto;
import com.itb.sms.mapper.StudentMapper;
import com.itb.sms.model.*;
import com.itb.sms.repository.*;
import com.itb.sms.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;
    private final StateRepository stateRepository;
    private final CityRepository cityRepository;
    private final PostRepository postRepository;
    private final UnionRepository unionRepository;
    private final AreaRepository areaRepository;
    private final LocationRepository locationRepository;
    private final StudentAddressRepository studentAddressRepository;
    private final ClassRepository classRepository;
    private final SectionRepository sectionRepository;
    private final GroupRepository groupRepository;
    private final SessionRepository sessionRepository;
    private final AcademicRepository academicRepository;

    public StudentServiceImpl(StudentMapper studentMapper, StudentRepository studentRepository, StateRepository stateRepository,
                              CityRepository cityRepository, PostRepository postRepository, UnionRepository unionRepository,
                              AreaRepository areaRepository, LocationRepository locationRepository, StudentAddressRepository studentAddressRepository,
                              ClassRepository classRepository, SectionRepository sectionRepository, GroupRepository groupRepository,
                              SessionRepository sessionRepository, AcademicRepository academicRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
        this.stateRepository = stateRepository;
        this.cityRepository = cityRepository;
        this.postRepository = postRepository;
        this.unionRepository = unionRepository;
        this.areaRepository = areaRepository;
        this.locationRepository = locationRepository;
        this.studentAddressRepository = studentAddressRepository;
        this.classRepository = classRepository;
        this.sectionRepository = sectionRepository;
        this.groupRepository = groupRepository;
        this.sessionRepository = sessionRepository;
        this.academicRepository = academicRepository;
    }

    @Override
    public StudentDto getById(Long id) {
        Optional<StudentInfo> entity = studentRepository.findById(id);

        return studentMapper.map(entity.get());

    }


    @Override
    public List<StudentDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return studentMapper.mapList(studentRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return studentMapper.mapList(studentRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        }

    }


    @Override
    public Integer saveOrUpdate(StudentDto dto) {

        try {
            StudentInfo studentInfo = studentRepository.save(studentMapper.map(dto));

            // Student Academic Record Information

            AcademicInfo academicInfo = new AcademicInfo();

            academicInfo.setId(dto.getAcademicRecordId());
            academicInfo.setStudentInfo(studentInfo);

            Optional<ClassInfo> classInfo = classRepository.findById(dto.getClassId());
            if (classInfo.isPresent()) {
                academicInfo.setClassInfo(classInfo.get());
            } else {

                new Exception("Class does not exist with id " + dto.getClassId());
            }

            Optional<SectionInfo> sectionInfo = sectionRepository.findById(dto.getSectionId());
            if (sectionInfo.isPresent()) {
                academicInfo.setSectionInfo(sectionInfo.get());
            } else {

                new Exception("Section does not exist with id " + dto.getSectionId());
            }
            academicInfo.setShiftId(dto.getShiftId());

            Optional<GroupInfo> groupInfo = groupRepository.findById(dto.getGroupId());
            if (groupInfo.isPresent()) {
                academicInfo.setGroupInfo(groupInfo.get());
            } else {

                new Exception("Group does not exist with id " + dto.getSectionId());
            }

            Optional<SessionInfo> sessionInfo = sessionRepository.findById(dto.getSessionId());
            if (sessionInfo.isPresent()) {
                academicInfo.setSessionInfo(sessionInfo.get());
            } else {

                new Exception("Session does not exist with id " + dto.getSessionId());
            }
            academicInfo.setRollNo(dto.getRollNo());
            academicInfo.setAdmissionDate(dto.getAdmissionDate());
            academicInfo.setAdmissionNo(dto.getAdmissionNo());
            academicInfo.setRegNo(dto.getRegNo());
            academicInfo.setStipendStatus(dto.getStipendStatus());
            academicInfo.setStipendType(dto.getStipendType());
            academicInfo.setScholarshipStatus(dto.getScholarshipStatus());
            academicInfo.setScholarshipType(dto.getScholarshipType());
            academicInfo.setRepeaterStatus(dto.getRepeaterStatus());
            academicInfo.setTransferStatus(dto.getTransferStatus());
            academicInfo.setEiin(dto.getEiin());
            academicInfo.setDropOutStatus(dto.getDropOutStatus());
            academicInfo.setVersionStatus(dto.getVersionStatus());

            AcademicInfo record = this.academicRepository.save(academicInfo);

            if (dto.getAcademicRecordId() == null) {

                studentInfo.setAcademicRecordId(record.getId());
            }


            // Student Present Address Information
            StudentAddressInfo presentAddressInfo = new StudentAddressInfo();

            presentAddressInfo.setId(dto.getPresentAddressId());

            presentAddressInfo.setStudentInfo(studentInfo);

            presentAddressInfo.setTypeId((byte) 1);

            Optional<StateInfo> presentDivisionInfo = stateRepository.findById(dto.getPresentDivisionId());
            if (presentDivisionInfo.isPresent()) {
                presentAddressInfo.setDivisionInfo(presentDivisionInfo.get());
            } else {

                new Exception("Division does not exist with id " + dto.getPresentDivisionId());
            }

            Optional<CityInfo> presentDistrictInfo = cityRepository.findById(dto.getPresentDistrictId());
            if (presentDistrictInfo.isPresent()) {
                presentAddressInfo.setDistrictInfo(presentDistrictInfo.get());
            } else {

                new Exception("District does not exist with id " + dto.getPresentDistrictId());
            }

            Optional<PostInfo> presentThanaInfo = postRepository.findById(dto.getPresentThanaId());
            if (presentThanaInfo.isPresent()) {
                presentAddressInfo.setThanaInfo(presentThanaInfo.get());
            } else {

                new Exception("Thana does not exist with id " + dto.getPresentThanaId());
            }

            Optional<UnionInfo> presentUnionInfo = unionRepository.findById(dto.getPresentUnionId());
            if (presentUnionInfo.isPresent()) {
                presentAddressInfo.setUnionInfo(presentUnionInfo.get());
            } else {

                new Exception("Union does not exist with id " + dto.getPresentUnionId());
            }
            presentAddressInfo.setPostOffice(dto.getPresentPostOffice());
            presentAddressInfo.setPostCode(dto.getPresentPostCode());
            presentAddressInfo.setAddress(dto.getPresentAddress());

            Optional<AreaInfo> presentAreaInfo = areaRepository.findById(dto.getPresentAreaStatusId());
            if (presentAreaInfo.isPresent()) {
                presentAddressInfo.setAreaInfo(presentAreaInfo.get());
            } else {

                new Exception("Area does not exist with id " + dto.getPresentUnionId());
            }

            Optional<LocationInfo> presentLocationInfo = locationRepository.findById(dto.getPresentGeoLocationId());
            if (presentLocationInfo.isPresent()) {
                presentAddressInfo.setLocationInfo(presentLocationInfo.get());
            } else {

                new Exception("Location does not exist with id " + dto.getPresentUnionId());
            }

            this.studentAddressRepository.save(presentAddressInfo);

            // Student Permanent Address Information
            StudentAddressInfo permanentAddressInfo = new StudentAddressInfo();

            permanentAddressInfo.setId(dto.getPresentAddressId());

            permanentAddressInfo.setStudentInfo(studentInfo);

            permanentAddressInfo.setTypeId((byte) 2);

            Optional<StateInfo> permanentDivisionInfo = stateRepository.findById(dto.getPermanentDivisionId());
            if (permanentDivisionInfo.isPresent()) {
                permanentAddressInfo.setDivisionInfo(permanentDivisionInfo.get());
            } else {

                new Exception("Division does not exist with id " + dto.getPresentDivisionId());
            }

            Optional<CityInfo> permanentDistrictInfo = cityRepository.findById(dto.getPermanentDistrictId());
            if (permanentDistrictInfo.isPresent()) {
                permanentAddressInfo.setDistrictInfo(permanentDistrictInfo.get());
            } else {

                new Exception("District does not exist with id " + dto.getPermanentDistrictId());
            }

            Optional<PostInfo> permanentThanaInfo = postRepository.findById(dto.getPermanentThanaId());
            if (permanentThanaInfo.isPresent()) {
                permanentAddressInfo.setThanaInfo(permanentThanaInfo.get());
            } else {

                new Exception("Thana does not exist with id " + dto.getPermanentThanaId());
            }

            Optional<UnionInfo> permanentUnionInfo = unionRepository.findById(dto.getPermanentUnionId());
            if (permanentUnionInfo.isPresent()) {
                permanentAddressInfo.setUnionInfo(permanentUnionInfo.get());
            } else {

                new Exception("Union does not exist with id " + dto.getPermanentUnionId());
            }
            permanentAddressInfo.setPostOffice(dto.getPermanentPostOffice());
            permanentAddressInfo.setPostCode(dto.getPermanentPostCode());
            permanentAddressInfo.setAddress(dto.getPermanentAddress());

            Optional<AreaInfo> permanentAreaInfo = areaRepository.findById(dto.getPermanentAreaStatusId());
            if (permanentAreaInfo.isPresent()) {
                permanentAddressInfo.setAreaInfo(permanentAreaInfo.get());
            } else {

                new Exception("Area does not exist with id " + dto.getPermanentUnionId());
            }

            Optional<LocationInfo> permanentLocationInfo = locationRepository.findById(dto.getPresentGeoLocationId());
            if (permanentLocationInfo.isPresent()) {
                permanentAddressInfo.setLocationInfo(permanentLocationInfo.get());
            } else {

                new Exception("Location does not exist with id " + dto.getPermanentUnionId());
            }

            this.studentAddressRepository.save(permanentAddressInfo);

            return 1;
        } catch (Exception ex) {

            return -1;
        }
    }


}
