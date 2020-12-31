package com.zgjt.yqsl.hystrix;

import com.zgjt.yqsl.feign.ProviderClient;
import com.zgjt.yqsl.response.ResponseApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProviderClientImpl implements ProviderClient {
    @Override
    public ResponseApi sendCodeSms(String phone) {
        log.error(phone);
        return ResponseApi.error().message("调用失败了");
    }
}
