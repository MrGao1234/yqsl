package com.zgjt.yqsl.feign;

import com.zgjt.yqsl.hystrix.ProviderClientImpl;
import com.zgjt.yqsl.response.ResponseApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nacos-alibaba",fallback = ProviderClientImpl.class)
public interface ProviderClient {

    @PostMapping("/alibaba/sms/codeSms")
    ResponseApi sendCodeSms(@RequestParam(value = "phone") String phone);
}
