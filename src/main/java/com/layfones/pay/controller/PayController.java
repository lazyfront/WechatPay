package com.layfones.pay.controller;

import com.layfones.pay.dto.PayDTO;
import com.layfones.pay.service.impl.PayService;
import com.layfones.pay.util.OrderUtil;
import com.lly835.bestpay.model.PayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private PayService payService;

    @PostMapping("/recharge")
    public String unifiedOrder() {
        final String orderCode = OrderUtil.getOrderCode(12);
        log.info("WX:::::orderCode={}", orderCode);
        final PayResponse payResponse = payService.create(orderCode, BigDecimal.valueOf(0.01));
        return payResponse.getMwebUrl();
    }

}
