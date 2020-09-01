package com.tk.config;

import javax.servlet.MultipartConfigElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application-servlet.properties", ignoreResourceNotFound = true)
public class MultipartConfig {
	
	 @Value("${spring.servlet.maxFileSize}")
	 private String maxFileSize;
	 
	 @Value("${spring.servlet.maxRequestSize}")
	 private String maxRequestSize;
	
	 @Bean
	 public MultipartConfigElement multipartConfigElement(){
	        MultipartConfigFactory factory = new MultipartConfigFactory();
	        factory.setMaxFileSize(maxFileSize);
	        factory.setMaxRequestSize(maxRequestSize);
	        return factory.createMultipartConfig();
	  }

}
