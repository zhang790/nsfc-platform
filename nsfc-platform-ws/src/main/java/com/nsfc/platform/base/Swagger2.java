package com.nsfc.platform.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 添加自动的Swagger2的api文档
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/3
 */
@Configuration   //通过该标签  使Spring加载该配置
@EnableSwagger2  //启动Swagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nsfc.platform.user"))  //指定扫描的api的包
                .paths(PathSelectors.any())
                .build();

    }

    /**
     * 构建api文档的基础信息
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("SpringBoot学习项目的api文档")
                .description("SpringBoot项目")
                .termsOfServiceUrl("http://47.104.29.8/")
                .contact("不知先生")
                .version("v1.0")
                .build();
    }

}
