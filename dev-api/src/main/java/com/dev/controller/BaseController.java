package com.dev.controller;

import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    //购物车
    public static final String SHOPCARD  = "shopcard";
    //默认 limit = 10
    public static final Integer LIMIT = 10;
    public static final Integer OFFSET = 1;
    public static final Integer PAGE_SIZE = 20;
    String payReturnUrl = "http://localhost:8088/orders/notifyMerchantOrderPaid";
    String payMomentURl = "http://payment.t.mukewang.com/foodie-payment/payment/createMerchantOrder";
}
