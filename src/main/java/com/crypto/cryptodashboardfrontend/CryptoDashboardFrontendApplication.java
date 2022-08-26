package com.crypto.cryptodashboardfrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
//@ComponentScan(basePackages = { "com.crypto.cryptodashboardfrontend" })
@EnableAsync
public class CryptoDashboardFrontendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CryptoDashboardFrontendApplication.class, args);
    }

}
