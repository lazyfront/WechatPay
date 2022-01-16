package com.layfones.pay.service.impl;

import com.layfones.pay.service.IPayService;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class PayService implements IPayService {
    /**
     * 创建/发起支付  5450341
     *
     * @param orderId 订单号
     * @param amount  金额
     */
    @Override
    public PayResponse create(String orderId, BigDecimal amount) {
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId("wxd898fcb01713c658");
//        wxPayConfig.setAppSecret();
        wxPayConfig.setMchId("1483469312");
        wxPayConfig.setMchKey("7mdApPMfXddfWWbbP4DUaVYm2wjyh3v3");
        wxPayConfig.setNotifyUrl("http://www.codetoy.com ");

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);

        PayRequest payRequest = new PayRequest();
        payRequest.setOrderName("5450341-CunZhengTong");
        payRequest.setOrderId(orderId);
        payRequest.setOrderAmount(amount.doubleValue());
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_MWEB);
//        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_NATIVE);
        bestPayService.pay(payRequest);

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("WX:response={}", payResponse);
        return payResponse;
    }

}
