package com.layfones.pay.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PayServiceTest {

//    @Autowired
    private PayService payService = new PayService();

    @Test
    void create() {
        payService.create("12345334249123456", BigDecimal.valueOf(0.01));
    }
}