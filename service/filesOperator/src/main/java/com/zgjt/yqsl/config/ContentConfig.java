package com.zgjt.yqsl.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ContentConfig {

    @Value("${server.servlet.context-path}")
    private String contentPath;

}
