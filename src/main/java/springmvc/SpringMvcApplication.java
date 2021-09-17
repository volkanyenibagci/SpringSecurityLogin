package springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({"springmvc","controller","model"})
//@Controller
public class SpringMvcApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}
