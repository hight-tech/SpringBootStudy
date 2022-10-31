package com.yang.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * springbootAdminClient添加Health信息
 * @Author yang
 * @Date 2022/8/8
 */
@Component
public class HealthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Boolean condition =true;
        if (condition){
            builder.status(Status.UP);//设置健康状态为UP
            builder.withDetail("rumtime",new Date(System.currentTimeMillis()).toString());
            Map info = new HashMap();
            info.put("buildTime","2022");
            builder.withDetails(info);
//            builder.up();//设置健康状态为UP
        }else {
            builder.withDetail("快下班了吗？","还没呢~！");
//            builder.down();
            builder.status(Status.OUT_OF_SERVICE);
        }
    }
}
