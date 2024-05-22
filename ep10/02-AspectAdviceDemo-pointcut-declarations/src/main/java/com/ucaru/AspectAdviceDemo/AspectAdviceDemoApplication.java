package com.ucaru.AspectAdviceDemo;

import com.ucaru.AspectAdviceDemo.service.TrafficFortuneService;
import com.ucaru.AspectAdviceDemo.dao.AccountDAO;
import com.ucaru.AspectAdviceDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AspectAdviceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectAdviceDemoApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(AccountDAO dao, MembershipDAO mdao, TrafficFortuneService service)
	{
		return runner -> {

			//demoBeforeAdvice(dao, mdao);
			//demoAfterReturningAdvice(dao);
			//demoAfterThrowingAdvice(dao);
			//demoAfterAdvice(dao);
			//demoAroundAdvice(service);
			demoAroundAdviceHandleExc(service);
		};
	}

	private void demoAroundAdviceHandleExc(TrafficFortuneService service) {

		System.out.println("main exc handler demo");
		System.out.println("call fortune");

		boolean tripWire = true;

		String data = service.getFortune(tripWire);
		System.out.println("data: " + data);

	}

	private void demoAroundAdvice(TrafficFortuneService service) {

		System.out.println("main");
		System.out.println("call fortune");
		String data = service.getFortune();
		System.out.println("data: " + data);
	}

	private void demoAfterAdvice(AccountDAO dao) {

		List<Account> accountList = null;
		try
		{
			//set true if you want exception
			boolean tripWire = true;
			accountList = dao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("caught: " + e);
		}
		System.out.println("main");
		System.out.println(accountList);

	}
	private void demoAfterThrowingAdvice(AccountDAO dao) {


		List<Account> accountList = null;
		try
		{
			boolean tripWire = true;
			accountList = dao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("caught: " + e);
		}
		System.out.println("main");
		System.out.println(accountList);

	}

	private void demoAfterReturningAdvice(AccountDAO dao) {

		List<Account> accountList = dao.findAccounts();

		System.out.println(accountList);
	}

	private void demoBeforeAdvice(AccountDAO dao, MembershipDAO mdao) {

		dao.addAccount(new Account("mahmud", "high level"), true);
		mdao.addAccount();


		//call get/set
		dao.setName1("1");
		dao.setName2("2");
		dao.getName1();
		dao.getName2();


	}


}
