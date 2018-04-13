package com.nsfc.platform.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //排除数据库自动配置影响
@ComponentScan("com.nsfc")
@MapperScan("com.nsfc.platform.*.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class PlatformWsApplication { //加上这个是为了使用外部分容器

	public static void main(String[] args) {
		SpringApplication.run(PlatformWsApplication.class, args);
	}
}
