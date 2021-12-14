package com.example.demo.controller;

import com.shopwinner.saas.common.annotation.Adopt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 功能描述：
 *
 * @Author: hanlq
 * @Date: 2021/4/29 15:55
 */
@FeignClient(name = "saas-gateway-web")
public interface GateWayFeign {
    @GetMapping(value = "/ResCode/api/responseCode/init")
    public String initResultCode();
}
