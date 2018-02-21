package swax.web.boot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import swax.webservice.main.Application;
@SpringBootApplication@Import({Application.class, SwaxMvcConfig.class})@ComponentScan({"swax.web.controller.*","swax.web.mav"})public class SpringConfigWebApplication extends SpringBootServletInitializer {
	@Override	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {		return application.sources(SpringConfigWebApplication.class);	}
	public static void main(String[] args) throws Exception {		SpringApplication.run(SpringConfigWebApplication.class, args);	}
}
