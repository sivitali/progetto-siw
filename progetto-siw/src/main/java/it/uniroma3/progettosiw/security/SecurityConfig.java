package it.uniroma3.progettosiw.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

	public class SecurityConfig  extends WebSecurityConfigurerAdapter {
		
		 @Autowired

		    private DataSource dataSource;

		 

			@Override

			protected void configure(AuthenticationManagerBuilder auth) throws Exception {



				auth.jdbcAuthentication().dataSource(dataSource)

				.usersByUsernameQuery("select username,password, enabled from users where username=?")

				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");

			}

		 

			@Override

			protected void configure(HttpSecurity http) throws Exception {

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

		 

		}
