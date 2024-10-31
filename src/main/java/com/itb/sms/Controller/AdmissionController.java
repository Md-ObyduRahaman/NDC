package com.itb.sms.Controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itb.sms.dto.ApplicationResponseDto;
import com.itb.sms.dto.NdcApplicationDto;
import com.itb.sms.dto.NdcApplicationUpdateDto;
import com.itb.sms.dto.NdcCategoryDto;
import com.itb.sms.utility.ApiUrl;
import com.itb.sms.utility.AppUtil;

@Controller
public class AdmissionController {

    private static final Logger log = LoggerFactory.getLogger(AdmissionController.class);

    @GetMapping({"/","/ndc"})
    private String welcome(@ModelAttribute("msg") String msg,Model model) {

        log.info("NDC Home Page");
       if(msg.isEmpty())
       {
    	   model.addAttribute("msg",1);
    	   
       }
       else {
    	   model.addAttribute("msg",msg);
	}
        System.out.println(msg);
        

        return "/admission/ndc_login";
    }




    @GetMapping(value = {"/ndc/application"})
    private String application(Model model) {

        log.info("NDC Application Page");
        
        List<NdcCategoryDto> getCategoryList=AppUtil.getCategoryList();

        model.addAttribute("catList", AppUtil.getCategoryList());
        model.addAttribute("groupList", AppUtil.getGroupList());
        model.addAttribute("religionList", AppUtil.getReligionList());
        model.addAttribute("boardList", AppUtil.getBoardList());
        model.addAttribute("locationList", AppUtil.getSchoolLocationList());
        model.addAttribute("versionList", AppUtil.getVersionList());
        model.addAttribute("captcha", AppUtil.getCaptcha());

        return "admission/application";
    }

    @PostMapping(value = {"/ndc/login"})
    private String submitLogin(@RequestParam(name = "mobile_no") String mobile_no,
                               @RequestParam(name = "password") String password,RedirectAttributes redirectAttributes,
                               HttpSession session, Model model) throws IOException {
        log.info("NDC Login Method");
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("p_SMS_MOBILE_NO", mobile_no);
        map.add("p_User_Pass", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(ApiUrl.NDC_DPD_USER_LOGIN_DATA_API, request, String.class);

        if (response.getBody().equals("2")) {
            ApplicationResponseDto application = AppUtil.getApplicationInfo(mobile_no, password);
            session.setAttribute("studentInfo", application);
            return "redirect:/ndc/dashboard";
        } else {
        	String msg = "User Id Password Missmatch! Login Failed";
			redirectAttributes.addFlashAttribute("msg", msg);

			System.out.println("Eroorr");
            return "redirect:/ndc";
        }

    }

    @GetMapping({"/ndc/application_edit"})
    private String applicationEdit(HttpSession httpSession,Model model) {
        ApplicationResponseDto studentInfo = (ApplicationResponseDto) httpSession.getAttribute("studentInfo");
        model.addAttribute("catList", AppUtil.getCategoryList());
        model.addAttribute("groupList", AppUtil.getGroupList());
        model.addAttribute("religionList", AppUtil.getReligionList());
        model.addAttribute("boardList", AppUtil.getBoardList());
        model.addAttribute("locationList", AppUtil.getSchoolLocationList());
        model.addAttribute("versionList", AppUtil.getVersionList());
        model.addAttribute("studentInfo", studentInfo);
        model.addAttribute("captcha", AppUtil.getCaptcha());
        return "admission/application_edit";
    }

    @GetMapping({"/ndc/dashboard"})
    private String dashboard(Model model, HttpSession httpSession) {
        log.info("NDC dashboard");
        ApplicationResponseDto studentInfo = (ApplicationResponseDto) httpSession.getAttribute("studentInfo");
        model.addAttribute("studentInfo", studentInfo);
        return "admission/admission_dashboard";
    }

    @GetMapping({"/ndc/admission"})
    private String admission() {

        return "admission/admission_form";
    }

    @GetMapping({"/ndc/admission_view"})
    private String admissionView() {

        return "admission/admission_view";
    }

    @GetMapping({"/ndc/payment"})
    private String payment(Model model, HttpSession httpSession) {

        ApplicationResponseDto studentInfo = (ApplicationResponseDto) httpSession.getAttribute("studentInfo");
        model.addAttribute("studentInfo", studentInfo);

        return "admission/admission_payment";
    }

    @PostMapping(value = "/ndc/application/save")
    public String  add(@ModelAttribute("applicationInfo") NdcApplicationDto dto) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("APP_MODE","JAVA");
        map.add("APP_ROLL_NO", dto.getAPP_ROLL_NO());
        map.add("APP_CAT", dto.getAPP_CAT());
        map.add("imdata", dto.getImdata());
        map.add("STD_NAME", dto.getSTD_NAME());
        map.add("STD_MOBILE_NO", dto.getSTD_MOBILE_NO());
        map.add("RG_CODE", dto.getRG_CODE());
        map.add("RG_SECT", dto.getRG_SECT());
        map.add("F_NAME", dto.getF_NAME());
        map.add("F_MOBILE_NO", dto.getF_MOBILE_NO());
        map.add("M_NAME", dto.getM_NAME());
        map.add("M_MOBILE_NO", dto.getM_MOBILE_NO());
        map.add("SCHOOL_NAME", dto.getSCHOOL_NAME());
        map.add("BOARD_CODE", dto.getBOARD_CODE());
        map.add("EXAM_ROLL_NO", dto.getEXAM_ROLL_NO());
        map.add("REG_NO", dto.getREG_NO());
        map.add("SESSION_NO", dto.getSESSION_NO());
        map.add("EXAM_YEAR", dto.getEXAM_YEAR());
        map.add("LOC_CODE", dto.getLOC_CODE());
        map.add("SSC_GR_CODE", dto.getSSC_GR_CODE());
        map.add("GP_BANG", dto.getGP_BANG());
        map.add("GP_ENG", dto.getGP_ENG());
        map.add("GP_RELI", dto.getGP_RELI());
        map.add("GP_MATH", dto.getGP_MATH());
        map.add("GP_PHY", dto.getGP_PHY());
        map.add("GP_CHE", dto.getGP_CHE());
        map.add("GP_BIO", dto.getGP_BIO());
        map.add("GP_HMATH", dto.getGP_HMATH());
        map.add("GP_SCI", dto.getGP_SCI());
        map.add("GP_ACC", dto.getGP_ACC());
        map.add("ADD_SUB_NAME", dto.getADD_SUB_NAME());
        map.add("GP_ADD_SUB", dto.getGP_ADD_SUB());
        map.add("SSC_GPA", dto.getSSC_GPA());
        map.add("TOTAL_APLUS", dto.getTOTAL_APLUS());
        map.add("SSC_MARKS", "0");
        map.add("SSC_VERSION", dto.getSSC_VERSION());
        map.add("SMS_MOBILE_NO", dto.getSMS_MOBILE_NO());
        map.add("EXAM_SUB_NAME1", dto.getEXAM_SUB_NAME1());
        map.add("GP_EXAM_SUB1", dto.getGP_EXAM_SUB1());
        map.add("EXAM_SUB_NAME2", dto.getEXAM_SUB_NAME2());
        map.add("GP_EXAM_SUB2", dto.getGP_EXAM_SUB2());
        map.add("EXAM_SUB_NAME3", dto.getEXAM_SUB_NAME3());
        map.add("GP_EXAM_SUB3", dto.getGP_EXAM_SUB3());
        map.add("EXAM_SUB_NAME4", dto.getEXAM_SUB_NAME4());
        map.add("GP_EXAM_SUB4", dto.getGP_EXAM_SUB4());
        map.add("OTP", dto.getOTP());
        map.add("TB_EXAM_ROLL_NO", dto.getTB_EXAM_ROLL_NO());
        map.add("TB_REG_NO", dto.getTB_REG_NO());
        map.add("GP_ECO", dto.getGP_ECO());
        map.add("GP_CIVICS", dto.getGP_CIVICS());
        map.add("GP_GEO", dto.getGP_GEO());
        map.add("GP_QURAN", dto.getGP_QURAN());
        map.add("GP_ARABIC", dto.getGP_ARABIC());
        map.add("GP_AQAID", dto.getGP_AQAID());
        map.add("GP_ISLAM", dto.getGP_ISLAM());
        map.add("GP_SCIENCE", dto.getGP_SCIENCE());
        map.add("GP_FIN", dto.getGP_FIN());
        map.add("GP_BUSINT", dto.getGP_BUSINT());
        map.add("TOTAL_MARKS", dto.getTOTAL_MARKS());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        log.info("Create Request Body :"+request.toString());



         ResponseEntity<String> response =  restTemplate.postForEntity(ApiUrl.NDC_APPLICATION_INSERT_API, request, String.class);

        log.info("Create Response Body"+response.getBody());
        if(response.getBody().equals("1")){
            log.info("Success Return"+response.getBody());
            log.info("Saved");
        }else{
            log.info("Failed Return "+response.getBody());
        }


            return "redirect:/ndc";
    }

    @PostMapping(value = "/ndc/application/update")
    public String  update(@ModelAttribute("updateInfo") NdcApplicationUpdateDto dto, HttpSession httpSession) throws IOException {

        log.info("update");

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("APP_MODE","JAVA");
        map.add("APP_ROLL_NO",dto.getAPP_ROLL_NO());
        map.add("APP_CAT", dto.getAPP_CAT());
        map.add("imdata", dto.getImdata());
        map.add("STD_NAME", dto.getSTD_NAME());
        map.add("STD_MOBILE_NO", dto.getSTD_MOBILE_NO());
        map.add("RG_CODE", dto.getRG_CODE());
        map.add("RG_SECT", dto.getRG_SECT());
        map.add("F_NAME", dto.getF_NAME());
        map.add("F_MOBILE_NO", dto.getF_MOBILE_NO());
        map.add("M_NAME", dto.getM_NAME());
        map.add("M_MOBILE_NO", dto.getM_MOBILE_NO());
        map.add("SCHOOL_NAME", dto.getSCHOOL_NAME());
        map.add("BOARD_CODE", dto.getBOARD_CODE());
        map.add("EXAM_ROLL_NO", dto.getEXAM_ROLL_NO());
        map.add("REG_NO", dto.getREG_NO());
        map.add("SESSION_NO", dto.getSESSION_NO());
        map.add("EXAM_YEAR", dto.getEXAM_YEAR());
        map.add("LOC_CODE", dto.getLOC_CODE());
        map.add("SSC_GR_CODE", dto.getSSC_GR_CODE());
        map.add("GP_BANG", dto.getGP_BANG().replace(",", ""));
        map.add("GP_ENG", dto.getGP_ENG().replace(",", ""));
        map.add("GP_RELI", dto.getGP_RELI());
        map.add("GP_MATH", dto.getGP_MATH().replace(",", ""));
        map.add("GP_PHY", dto.getGP_PHY());
        map.add("GP_CHE", dto.getGP_CHE());
        map.add("GP_BIO", dto.getGP_BIO());
        map.add("GP_HMATH", dto.getGP_HMATH());
        map.add("GP_SCI", dto.getGP_SCI());
        map.add("GP_ACC", dto.getGP_ACC());
        map.add("ADD_SUB_NAME", dto.getADD_SUB_NAME());
        map.add("GP_ADD_SUB", dto.getGP_ADD_SUB());
        map.add("SSC_GPA", dto.getSSC_GPA());
        map.add("TOTAL_APLUS", dto.getTOTAL_APLUS());
        map.add("SSC_MARKS", dto.getSSC_MARKS());
        map.add("SSC_VERSION", dto.getSSC_VERSION());
        map.add("SMS_MOBILE_NO", dto.getSMS_MOBILE_NO());
        map.add("EXAM_SUB_NAME1", dto.getEXAM_SUB_NAME1());
        map.add("GP_EXAM_SUB1", dto.getGP_EXAM_SUB1());
        map.add("EXAM_SUB_NAME2", dto.getEXAM_SUB_NAME2());
        map.add("GP_EXAM_SUB2", dto.getGP_EXAM_SUB2());
        map.add("EXAM_SUB_NAME3", dto.getEXAM_SUB_NAME3());
        map.add("GP_EXAM_SUB3", dto.getGP_EXAM_SUB3());
        map.add("EXAM_SUB_NAME4", dto.getEXAM_SUB_NAME4());
        map.add("GP_EXAM_SUB4", dto.getGP_EXAM_SUB4());
        map.add("OTP", dto.getOTP());
        map.add("TB_EXAM_ROLL_NO", dto.getTB_EXAM_ROLL_NO());
        map.add("TB_REG_NO", dto.getTB_REG_NO());
        map.add("GP_ECO", dto.getGP_ECO());
        map.add("GP_CIVICS", dto.getGP_CIVICS());
        map.add("GP_GEO", dto.getGP_GEO());
        map.add("GP_QURAN", dto.getGP_QURAN());
        map.add("GP_ARABIC", dto.getGP_ARABIC());
        map.add("GP_AQAID", dto.getGP_AQAID());
        map.add("GP_ISLAM", dto.getGP_ISLAM());
        map.add("GP_SCIENCE", (dto.getGP_SCIENCE()!=null?dto.getGP_SCIENCE().replace(",", ""):dto.getGP_SCIENCE()));
        map.add("GP_FIN", dto.getGP_FIN());
        map.add("GP_BUSINT", dto.getGP_BUSINT());
        map.add("TOTAL_MARKS", dto.getTOTAL_MARKS());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        log.info("Update Request Body"+request.toString());
        ResponseEntity<String> response =  restTemplate.postForEntity(ApiUrl.NDC_APPLICATION_UPDATE_API, request, String.class);
        log.info("Update Response"+response.getBody());
         if (response.getBody().equals("1")) {
            ApplicationResponseDto application = AppUtil.getApplicationInfo(dto.getSMS_MOBILE_NO(), dto.getOTP());
            httpSession.setAttribute("studentInfo", application);


        }

        log.info("Update Response Body"+response.getBody());
        if(response.getBody().equals("1")){
            log.info("Success Return"+response.getBody());
            log.info("Saved");
        }else{
            log.info("Failed Return "+response.getBody());
        }



        return "redirect:/ndc/application_edit";
    }

    @GetMapping(value = {"/ndc/admit"})
    private String admitCard(Model model,HttpSession httpSession) throws IOException {

        ApplicationResponseDto studentInfo = (ApplicationResponseDto) httpSession.getAttribute("studentInfo");
        model.addAttribute("studentInfo", studentInfo);
        model.addAttribute("seatPlanInfo", AppUtil.getSeatPlanInfo(studentInfo.getAPP_ID()));

        return "admission/admit_card";
    }

    @GetMapping(value = {"/ndc/pay_slip"})
    private String paySlip(Model model,HttpSession httpSession) throws IOException {

        System.out.println("\n Pay Slip");
        ApplicationResponseDto studentInfo = (ApplicationResponseDto) httpSession.getAttribute("studentInfo");
        model.addAttribute("studentInfo", studentInfo);
        model.addAttribute("paySlipInfo", AppUtil.getPaySlipInfo(studentInfo.getAPP_ID(),"App Fee"));

        return "admission/pay_slip";
    }
    @GetMapping({"/ndc/logout"})
    private String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/ndc";
    }

}
