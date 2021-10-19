package com.tyranotyrano.swaggerlearning.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger URL 경로
 * 	- (Swagger2: http://localhost:8080/swagger-ui.html)
 * 	- Swagger3: http://localhost:8080/swagger-ui/index.html
 *
 * 	※ reference
 * 	- https://bcp0109.tistory.com/326
 * 	- https://otrodevym.tistory.com/entry/spring-boot-%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-4-Swagger-%EC%84%A4%EC%A0%95-%EB%B0%8F-%EC%82%AC%EC%9A%A9-%EB%B0%A9%EB%B2%95
 * 	- https://lemontia.tistory.com/1000
 * */
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
			.useDefaultResponseMessages(false)
			.apiInfo(getApiInfo())

			.securityContexts(Collections.singletonList(securityContext()))
			.securitySchemes(Collections.singletonList(getApiKey()))

			.select()
			.apis(RequestHandlerSelectors.basePackage("com.tyranotyrano.swaggerlearning"))
			.paths(PathSelectors.any())
			.build();
	}

	// Swagger UI 에 보여지는 정보)
	private ApiInfo getApiInfo() {
		return new ApiInfo("Swagger Learning REST API Documentation",    // swagger 제목
			"REST Api Documentation",       // swagger 설명
			"3.0",                             // swagger 버전
			"localhost:8080",
			new Contact("tyranotyrano", "", "test@tyranotyrano.com"), //작성자 정보
			"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<>());
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
							  .securityReferences(defaultAuth())
							  .build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Collections.singletonList(new SecurityReference("Bearer {accessToken}", authorizationScopes));
	}

	private ApiKey getApiKey() {
		return new ApiKey("Bearer {accessToken}", "Authorization", "header");
	}
}
