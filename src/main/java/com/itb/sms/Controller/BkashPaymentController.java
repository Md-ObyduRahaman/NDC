package com.itb.sms.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itb.sms.dto.*;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.BookService;
import com.itb.sms.service.ClassTimeService;
import com.itb.sms.service.UserService;
import com.itb.sms.service.impl.BkashTokenServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "payment")
public class BkashPaymentController {

    private final BkashTokenServiceImpl bkashTokenServiceImpl;

    public BkashPaymentController(BkashTokenServiceImpl bkashTokenServiceImpl) {
        this.bkashTokenServiceImpl = bkashTokenServiceImpl;
    }


    @GetMapping("/token")
    public ResponseEntity<BkashTokenDto> getToken(){

        return ResponseEntity.ok(this.bkashTokenServiceImpl.getToken());
    }

    @GetMapping("/create")
    public ResponseEntity<BkashCreatePaymentResponseDto> create(@Valid @RequestBody BkashCreatePaymentRequestDto dto, @RequestParam(value = "token", required = false) String token) throws JsonProcessingException {

        return ResponseEntity.ok(this.bkashTokenServiceImpl.create(dto,token));
    }

    @GetMapping("/execute")
    public ResponseEntity<BkashExecutePaymentResponseDto> execute(@Valid @RequestBody BkashExecutePaymentRequestDto dto, @RequestParam(value = "token", required = false) String token) throws JsonProcessingException {

        return ResponseEntity.ok(this.bkashTokenServiceImpl.execute(dto,token));
    }


}
