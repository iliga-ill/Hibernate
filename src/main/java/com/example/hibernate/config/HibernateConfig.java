package com.example.hibernate.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

@Component
@RequiredArgsConstructor
public class HibernateConfig {
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;
//    @Value("${spring.datasource.url}")
//    private String datasourceUrl;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(datasourceUrl);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }

//    @Bean
//    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setPackagesToScan("com.example.model"); // Пакет с сущностями
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory;
//    }

//    private Properties hibernateProperties() {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.put("hibernate.show_sql", "true");
//        properties.put("hibernate.format_sql", "true");
//        return properties;
//    }
}