package com.yang.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * springbootAdminClient添加info信息
 * @Author yang
 * @Date 2022/8/8
 */

@Component
public class InfoConfig implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("rumtime",new Date(System.currentTimeMillis()).toString());
        Map info = new HashMap();
        info.put("buildTime","2022");
        builder.withDetails(info);
    }
}
