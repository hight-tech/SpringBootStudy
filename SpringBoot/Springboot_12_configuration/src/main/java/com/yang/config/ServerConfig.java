package com.yang.config;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @Author yang
 * @Date 2022/8/1
 */
@Data
//@Component
@ConfigurationProperties(prefix = "servers")    //绑定属性支持属性名宽松绑定
// 开启对当前Bean的属性注入校验
@Validated
public class ServerConfig {
    private String ipAddress;
    // 设置具体的规则
    @Max(value = 8888,message = "最大值不能超过8888")
    @Min(value = 202,message = "最小值不能超过202")
//    @Range
    private Integer port;
    private Long timeout;
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;

//    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}
