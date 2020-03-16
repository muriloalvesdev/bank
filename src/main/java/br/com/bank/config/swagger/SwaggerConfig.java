package br.com.bank.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(apis()).paths(PathSelectors.any())
        .build().apiInfo(metaData());
  }

  private Predicate<RequestHandler> apis() {
    return RequestHandlerSelectors.basePackage("br.com.bank");
  }

  private ApiInfo metaData() {
    return new ApiInfoBuilder().title("Project Spring Boot - Module Bank").description(
        "Module responsible for receiving a request from the Holder module and debiting it to the customer's account or within the limit of the informed credit card.")
        .version("1.0.0").license("Apache License Version 2.0")
        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"").build();
  }
}
