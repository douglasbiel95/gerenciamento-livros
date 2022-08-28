package com.douglasgabriel.gerenciamentolivros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "com.douglasgabriel.gerenciamentolivros";
	private static final String BUILD_API_INFO_TITULO = "Gerenciamento de Livros";
	private static final String BUILD_API_INFO_DESCRICAO = "Aplicação de Gerenciamento de Livros";
	private static final String BUILD_API_INFO_VERSAO = "1.0.0";
	private static final String BUILD_API_INFO_CONTATO_NOME = "Douglas Gabriel";
	private static final String BUILD_API_INFO_CONTATO_EMAIL = "douglaasg11@gmail.com";
	private static final String BUILD_API_INFO_CONTATO_GITHUB = "https://github.com/douglasbiel95";
			
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(buildApiInfo());
	}

	private ApiInfo buildApiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder()
				.title(BUILD_API_INFO_TITULO)
				.description(BUILD_API_INFO_DESCRICAO)
				.version(BUILD_API_INFO_VERSAO)
				.contact(new Contact(BUILD_API_INFO_CONTATO_NOME, BUILD_API_INFO_CONTATO_GITHUB , BUILD_API_INFO_CONTATO_EMAIL))
				.build();
	}
}
