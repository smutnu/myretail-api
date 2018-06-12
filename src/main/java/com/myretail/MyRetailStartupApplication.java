package com.myretail;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Satya
 * 
 * MyRetailStartupApplication class is SpringBootApplication to start the 
 * application with embedded Tomcat container.
 */

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@Configurable
public class MyRetailStartupApplication {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MyRetailStartupApplication.class,args);
	}
}
