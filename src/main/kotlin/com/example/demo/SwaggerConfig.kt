package com.example.demo

import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry



@Configuration
@EnableSwagger2
class SwaggerConfig : WebMvcConfigurer {
    @Bean
    fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
            .build()

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        //enabling swagger-ui part for visual documentation
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/")
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
    }
}
