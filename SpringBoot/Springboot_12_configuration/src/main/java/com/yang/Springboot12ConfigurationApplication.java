package com.yang;

import com.alibaba.druid.pool.DruidDataSource;
import com.yang.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(ServerConfig.class)
public class Springboot12ConfigurationApplication {

	@Bean
	@ConfigurationProperties(prefix = "datasource")
	public DruidDataSource druidDataSource(){
		DruidDataSource ds = new DruidDataSource();
//		ds.setDriverClassName("com.mysql.jdbc.Driver");
		return ds;
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(Springboot12ConfigurationApplication.class, args);
		ServerConfig bean = run.getBean(ServerConfig.class);
		System.out.println(bean);
		DruidDataSource ds = run.getBean(DruidDataSource.class);

		System.out.println(ds.getDriverClassName());
	}

}
