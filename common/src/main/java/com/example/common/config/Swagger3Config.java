package com.example.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger3Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30) //指定为swagger3
                .apiInfo(apiInfo())
                .select()
                //指定需要被扫描的接口的位置
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .paths(PathSelectors.any())
//                .paths(PathSelectors.ant())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("更多请咨询服务开发者")
                .contact(new Contact("移动真卡", "http://www.yidongzhenka.top", "xiaozhiwei@mail.ynu.edu.cnn"))
                .version("1.0")
                .build();
    }
}