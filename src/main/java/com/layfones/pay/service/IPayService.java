package com.layfones.pay.service;


import com.lly835.bestpay.model.PayResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


public interface IPayService {

    /**
     * 创建/发起支付
     * @param orderId 订单号
     * @param amount 金额
     */
    PayResponse create(String orderId, BigDecimal amount);

}
