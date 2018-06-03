package com.imooc.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
@EntityScan(basePackages = {"com.imooc.entity"})
public class SellerApp {

    public static void main(String[] args) {
        SpringApplication.run(SellerApp.class);
    }
}
