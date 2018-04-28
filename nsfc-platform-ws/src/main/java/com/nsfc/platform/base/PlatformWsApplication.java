package com.nsfc.platform.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication //排除数据库自动配置影响
@ComponentScan("com.nsfc")		//启动扫描的包
@MapperScan("com.nsfc.platform.*.mapper")//将项目中对应的mapper类的路径加进来就可以了
@EnableCaching //@EnableCaching会为每个bean中被 @Cacheable, @CachePut and @CacheEvict修饰的public方法进行缓存操作
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true, encoding = "UTF-8") //本地启动 指定一下加载属性
public class PlatformWsApplication extends SpringBootServletInitializer { //加上这个是为了使用外部分容器

	public static void main(String[] args) {
		SpringApplication.run(PlatformWsApplication.class, args);
	}

}
