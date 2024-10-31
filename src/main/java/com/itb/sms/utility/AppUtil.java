package com.itb.sms.utility;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itb.sms.dto.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AppUtil {


    public static String getCaptcha() {

        char data[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
                '7', '8', '9'};
        char index[] = new char[7];

        Random r = new Random();
        int i;

        for (i = 0; i < (index.length); i++) {
            int ran = r.nextInt(data.length);
            index[i] = data[ran];
        }
        return new String(index);
    }

    public static List<NdcBoardDto> getBoardList() {

        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        ResponseEntity<NdcBoardDto[]> response = restTemplate.getForEntity(ApiUrl.NDC_DPD_BOARD_API,NdcBoardDto[].class);

        return Arrays.asList(response.getBody());
    }

    public static List<NdcGroupDto> getGroupList() {

        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        ResponseEntity<NdcGroupDto[]> response = restTemplate.getForEntity(ApiUrl.NDC_DPD_GROUP_API,NdcGroupDto[].class);

        return Arrays.asList(response.getBody());

    }

    public static List<NdcCategoryDto> getCategoryList() {

        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        ResponseEntity<NdcCategoryDto[]> response = restTemplate.getForEntity(ApiUrl.NDC_DPD_ADM_CAT_API,NdcCategoryDto[].class);

        return Arrays.asList(response.getBody());

    }

    public static List<NdcReligionDto> getReligionList() {

        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        ResponseEntity<NdcReligionDto[]> response = restTemplate.getForEntity(ApiUrl.NDC_DPD_RELIGION_API,NdcReligionDto[].class);

        return Arrays.asList(response.getBody());

    }

    public static List<NdcSchoolLocationDto> getSchoolLocationList() {

        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
        ResponseEntity<NdcSchoolLocationDto[]> response = restTemplate.getForEntity(ApiUrl.NDC_DPD_SCHOOL_LOC_API,NdcSchoolLocationDto[].class);

        return Arrays.asList(response.getBody());

    }

    public static List<NdcVersionDto> getVersionList() {

        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

// Note: here we are making this converter to process any kind of response,
// not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
       ResponseEntity<NdcVersionDto[]> response = restTemplate.getForEntity(ApiUrl.NDC_DPD_VERSION_API,NdcVersionDto[].class);

        return Arrays.asList(response.getBody());

    }

    public static List<NdcExamScheduleDto> getExamScheduleList() {

        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

// Note: here we are making this converter to process any kind of response,
// not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        ResponseEntity<NdcExamScheduleDto[]> response = restTemplate.getForEntity(ApiUrl.NDC_DPD_EXAM_SCH_API,NdcExamScheduleDto[].class);

        return Arrays.asList(response.getBody());

    }

    public static List<NdcPaymentStatusDto> getPaymentStatusList() {

        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();

// Note: here we are making this converter to process any kind of response,
// not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        ResponseEntity<NdcPaymentStatusDto[]> response = restTemplate.getForEntity(ApiUrl.NDC_PAYMENT_STATUS_API,NdcPaymentStatusDto[].class);

        return Arrays.asList(response.getBody());

    }

    public static ApplicationResponseDto getApplicationInfo(String mobileNo, String password) throws IOException {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("SMS_MOBILE_NO", mobileNo);
        map.add("User_Pass", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        String response = restTemplate.postForObject(ApiUrl.NDC_DPD_APPLICATION_DATA_API, request, String.class);
        String outputText = response.replaceAll("\\[", "").replaceAll("\\]", "");
        System.out.print("Student : "+outputText);
        ObjectMapper mapper = new ObjectMapper();
        ApplicationResponseDto applicationResponseDto = mapper.readValue(outputText, ApplicationResponseDto.class);


        return applicationResponseDto;

    }

    public static NdcSeatPlanDto getSeatPlanInfo(String appId) throws IOException {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("APP_ID", appId);


        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        String response = restTemplate.postForObject(ApiUrl.NDC_DPD_SELECT_SEAT_PLAN_API, request, String.class);
        String outputText = response.replaceAll("\\[", "").replaceAll("\\]", "");
        System.out.print("Student : "+outputText);
        ObjectMapper mapper = new ObjectMapper();
        NdcSeatPlanDto dto = mapper.readValue(outputText, NdcSeatPlanDto.class);


        return dto;

    }

    public static NdcPaySlipDto getPaySlipInfo(String appRollNo,String payType) throws IOException {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("p_APP_ROLL_NO", appRollNo);
        map.add("p_PAY_TYPE", payType);


        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        String response = restTemplate.postForObject(ApiUrl.NDC_DPD_SELECT_PAYMENT_API, request, String.class);
        String outputText = response.replaceAll("\\[", "").replaceAll("\\]", "");
        System.out.print("Pay Slip Info : "+outputText);
        ObjectMapper mapper = new ObjectMapper();
        NdcPaySlipDto dto = mapper.readValue(outputText, NdcPaySlipDto.class);


        return dto;

    }

}
