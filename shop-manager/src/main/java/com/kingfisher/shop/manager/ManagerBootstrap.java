package com.kingfisher.shop.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by fanxinglong on 2017/11/7.
 */
@SpringBootApplication
public class ManagerBootstrap extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ManagerBootstrap.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ManagerBootstrap.class, args);
    }
}
