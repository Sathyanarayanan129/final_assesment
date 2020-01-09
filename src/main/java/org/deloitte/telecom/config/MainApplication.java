package org.deloitte.telecom.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication(scanBasePackages = "org.deloitte.telecom")
@EnableTransactionManagement
@EnableJpaRepositories
@EntityScan("org.deloitte.telecom")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

    }



}

