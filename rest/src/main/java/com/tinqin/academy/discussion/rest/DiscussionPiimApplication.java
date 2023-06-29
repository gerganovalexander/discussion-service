package com.tinqin.academy.discussion.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.tinqin.academy.discussion"})
@ComponentScan(basePackages = {"com.tinqin.academy.discussion"})
@EntityScan(basePackages = {"com.tinqin.academy.discussion.data.models"})
@EnableJpaRepositories(basePackages = {"com.tinqin.academy.discussion.data.repositories"})
public class DiscussionPiimApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscussionPiimApplication.class, args);
    }
}
