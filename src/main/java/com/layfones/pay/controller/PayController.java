package com.layfones.pay.controller;

import com.layfones.pay.dto.PayDTO;
import com.layfones.pay.service.impl.PayService;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;

    @PostMapping("/recharge")
    public void unifiedOrder(@RequestBody @Validated PayDTO payDTO) {
        final PayResponse payResponse = payService.create("123424721912", BigDecimal.valueOf(0.01));

    }

}
