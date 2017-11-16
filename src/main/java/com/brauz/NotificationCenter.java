package com.brauz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = {"com.brauz.persistence.entity"})
@EnableJpaRepositories(basePackages = {"com.brauz.repository"})
@EnableAsync
public class NotificationCenter {
	public static void main(String[] args) {
		SpringApplication.run(NotificationCenter.class, args);
	}
}
