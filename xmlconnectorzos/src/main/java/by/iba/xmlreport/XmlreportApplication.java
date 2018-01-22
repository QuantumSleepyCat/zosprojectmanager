package by.iba.xmlreport;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "by.iba.*")
@EnableAutoConfiguration
public class XmlreportApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(XmlreportApplication.class).properties();
	}

	public static void main(String[] args) {
		SpringApplication.run(XmlreportApplication.class, args);


	}
}
