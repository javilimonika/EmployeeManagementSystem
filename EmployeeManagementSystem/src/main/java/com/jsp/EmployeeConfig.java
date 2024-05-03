package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jsp")
public class EmployeeConfig {
	@Bean //returns EntityManager object to IOC
	public EntityManager getEntityManager()
	{
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		return factory.createEntityManager();
	}
	@Bean //returns EntityTransaction object to IOC
	public EntityTransaction getEntityTransaction()
	{
		return getEntityManager().getTransaction();
		
	}

}
