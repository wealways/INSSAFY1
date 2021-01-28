package com.ssafy.pjt1.common.swagger;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicate;

import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	// 서버실행 -> url 입력
	// http://localhost:8000/swagger-ui.html

	private String version = "V1";
	private String title = "IN.SSAFY API " + version;

	@Bean
	public Docket api() {
		List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>();
		responseMessages.add(new ResponseMessageBuilder().code(200).message("OK !!!").build());
		responseMessages.add(new ResponseMessageBuilder().code(500).message("서버 문제 발생 !!!")
				.responseModel(new ModelRef("Error")).build());
		responseMessages.add(new ResponseMessageBuilder().code(404).message("페이지를 찾을 수 없습니다 !!!").build());
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName(version).select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.pjt1.controller")).paths(postPaths()).build()
				.useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET, responseMessages)
				.securitySchemes(Arrays.asList(apiKey())).securityContexts(Arrays.asList(securityContext()));
	}

	private Predicate<String> postPaths() {
		return PathSelectors.any();
		// return or(regex("/admin/.*"), regex("/user/.*"));
		// return regex("/admin/.*");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(title).description("<h3>9팀 API Reference</h3>").version("1.0").build();

	}

	// 아래 부터 끝까지 인증관련코드
	private ApiKey apiKey() {
		return new ApiKey("JWT", "auth_token", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
}
