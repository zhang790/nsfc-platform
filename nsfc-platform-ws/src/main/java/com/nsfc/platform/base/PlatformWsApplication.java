package com.nsfc.platform.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) //排除数据库自动配置影响
@ComponentScan("com.nsfc")
public class PlatformWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformWsApplication.class, args);
	}
}
