package com.mylabs.pds;

import com.mylabs.pds.service.GitHubService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.mylabs.pds.model")
public class LaboratoryApplication {

	public static void main(String[] args) {

		SpringApplication.run(LaboratoryApplication.class, args);
		GitHubService gitHubService = new GitHubService();
	}

}
