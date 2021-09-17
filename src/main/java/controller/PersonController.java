package controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Person;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Controller
public class PersonController {

	@RequestMapping("/person")
	public String person(Model model) {

		Person person = new Person();
		person.setAge(28);
		person.setFirstName("Volkannn");
		person.setLastName("Yenibağcı");
		model.addAttribute("person", person);
		return "personview";
	}

	@RequestMapping("/index")
	public String index(Model model) {

		Person person = new Person();
		person.setAge(28);
		person.setFirstName("Volkannn");
		person.setLastName("Yenibağcı");
		model.addAttribute("person", person);
		return "index";
	}

	/*@ResponseBody
	@RequestMapping("/")
	String entry() {

		return "My Spring Boot App";
	}*/

	@Configuration
	public class MvcConfig implements WebMvcConfigurer {

		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/home").setViewName("home");
			registry.addViewController("/").setViewName("home");
			registry.addViewController("/hello").setViewName("hello");
			registry.addViewController("/login").setViewName("login");
		}

	}

	@Configuration
	@EnableWebSecurity
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.authorizeRequests()
					.antMatchers("/", "/home").permitAll()
					.anyRequest().authenticated()
					.and()
					.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
					.logout()
					.permitAll();
		}

		@Bean
		@Override
		public UserDetailsService userDetailsService() {
			UserDetails user =
					User.withDefaultPasswordEncoder()
							.username("user")
							.password("password")
							.roles("USER")
							.build();

			return new InMemoryUserDetailsManager(user);
		}
	}
}