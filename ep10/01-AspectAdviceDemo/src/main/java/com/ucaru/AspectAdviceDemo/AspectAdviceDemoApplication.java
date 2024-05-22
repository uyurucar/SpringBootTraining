package com.ucaru.AspectAdviceDemo;

import com.ucaru.AspectAdviceDemo.dao.AccountDAO;
import com.ucaru.AspectAdviceDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectAdviceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectAdviceDemoApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(AccountDAO dao, MembershipDAO mdao)
	{
		return runner -> {

			demoBeforeAdvice(dao, mdao);

		};
	}

	private void demoBeforeAdvice(AccountDAO dao, MembershipDAO mdao) {


		dao.addAccount(new Account(), true);
		mdao.addAccount();
	}


}
