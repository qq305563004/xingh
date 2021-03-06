package com.tk.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource(value = "classpath:application-mysql.properties", ignoreResourceNotFound = true)
public class DruidConfig {
	 @Value("${spring.datasource.url}")
     private String dbUrl;

     @Value("${spring.datasource.username}")
     private String username;

     @Value("${spring.datasource.password}")
     private String password;

     @Value("${spring.datasource.driver-class-name}")
     private String driverClassName;

     @Value("${spring.datasource.initialSize}")
     private int initialSize;

     @Value("${spring.datasource.minIdle}")
     private int minIdle;

     @Value("${spring.datasource.maxActive}")
     private int maxActive;

     @Value("${spring.datasource.maxWait}")
     private int maxWait;

     @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
     private int timeBetweenEvictionRunsMillis;

     @Value("${spring.datasource.minEvictableIdleTimeMillis}")
     private int minEvictableIdleTimeMillis;

    
     @Bean // 声明其为Bean实例
     @Primary // 在同样的DataSource中，首先使用被标注的DataSource
     public DataSource dataSource() {
         DruidDataSource datasource = new DruidDataSource();

         datasource.setUrl(this.dbUrl);
         datasource.setUsername(username);
         datasource.setPassword(password);
         datasource.setDriverClassName(driverClassName);

         // configuration
         datasource.setInitialSize(initialSize);
         datasource.setMinIdle(minIdle);
         datasource.setMaxActive(maxActive);
         datasource.setMaxWait(maxWait);
         datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
         datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
         return datasource;
     }

}
