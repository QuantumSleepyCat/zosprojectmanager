package by.iba.xmlreport;

import by.iba.jpadb.db.JPAApplication;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "by.iba.*")
@EnableJpaRepositories(basePackages = {"by.iba.jpadb.db.dao"})
@EnableAutoConfiguration
public class XmlreportApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JPAApplication.class,XmlreportApplication.class).properties();
	}

	public static void main(String[] args) {
		SpringApplication
				.run(XmlreportApplication.class, args);
	}
}
