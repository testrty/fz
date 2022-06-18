//package com.feign;//package com.SwaggerConfig;
//
//
//import io.swagger.annotations.Contact;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//
//import springfox.documentation.builders.ParameterBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.*;
//
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.google.common.collect.Lists.newArrayList;
//
//
//@Configuration //配置类
//@EnableSwagger2// 开启Swagger2的自动配置
//public class SwaggerConfig {
//    private List<ApiKey> securitySchemes() {
//        return newArrayList(
//                new ApiKey("Authorization", "Authorization", "header"));
//    }
//
//    private List<SecurityContext> securityContexts() {
//        return newArrayList(
//                SecurityContext.builder()
//                        .securityReferences(defaultAuth())
//                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
//                        .build()
//        );
//    }
//
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return newArrayList(
//                new SecurityReference("Authorization", authorizationScopes));
//    }
//
//    @Bean
//    public Docket createRestApi() {
//        ParameterBuilder parameterBuilder = new ParameterBuilder();
//        List<Parameter>  parameters       = new ArrayList<>();
//        parameterBuilder.name("Authorization").description("认证token")
//                .modelRef(new ModelRef("string")).parameterType("header")
//                .required(false).build();
//        parameters.add(parameterBuilder.build());
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.md.mybatisplus.t.controller"))
////                .paths(PathSelectors.any())
//                .paths(PathSelectors.regex("^(?!auth).*$"))
//                .build()
////                .globalOperationParameters(parameters)
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts())
//                .apiInfo(apiInfo());
//    }
//
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("")
//                .description(" ")
//                .version("2.0")
//                .build();
//    }
//
//}
