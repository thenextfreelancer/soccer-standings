package com.sapient.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig
{

   @Bean
   public Docket postsApi()
   {
      return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select().paths(postPaths()).build();
   }

   private Predicate<String> postPaths()
   {
      return Predicates.or(PathSelectors.regex("/*.*"), PathSelectors.regex("/*"));
   }

   private ApiInfo apiInfo()
   {
      return new ApiInfoBuilder()
         .title("Sapient Demo API")
         .description("Sapient Demo API reference for developers")
         .termsOfServiceUrl("http://thenextfreelancer.com")
         .contact(new Contact("Arpit Mishra", "https://github.com/thenextfreelancer/soccer-standings", "thenextfreelancer@gmail.com"))
         .license("Opensource License")
         .licenseUrl("thenextfreelancer@gmail.com")
         .version("1.0")
         .build();
   }
   
   @Primary
   @Bean
   public LinkDiscoverers discoverers() {
       List<LinkDiscoverer> plugins = new ArrayList<>();
       plugins.add(new CollectionJsonLinkDiscoverer());
       return new LinkDiscoverers(SimplePluginRegistry.create(plugins));
   }
}
