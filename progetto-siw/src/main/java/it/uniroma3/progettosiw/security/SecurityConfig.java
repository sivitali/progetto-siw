package it.uniroma3.progettosiw.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

	@Autowired

	private DataSource dataSource;



	@Override

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {



		auth.jdbcAuthentication().dataSource(dataSource)
		
		.passwordEncoder(new BCryptPasswordEncoder())

		.usersByUsernameQuery("SELECT username,password, 1 FROM users where username=?")

		.authoritiesByUsernameQuery("SELECT username,authority, FROM authorities where username=?");

	}



	@Override

	public void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests().antMatchers("/","/home").permitAll().antMatchers("/admin").hasRole("ADMIN")
		.anyRequest().authenticated()     
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.permitAll();
		http.exceptionHandling().accessDeniedPage("/403");

	}
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("admin").password("password").roles("USER","ADMIN").build());
		return manager;
	}
}


