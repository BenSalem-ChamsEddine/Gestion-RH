package de.cynapsys.GestionEntretienService.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth) throws Exception{

/*
		auth.inMemoryAuthentication()
		.withUser("admin").password("123").roles("ADMIN");*/
//		auth.inMemoryAuthentication()
//		.withUser("user").password("123").roles("USER");
		/*
		auth.jdbcAuthentication()
			.dataSource(postgresTemplate.getDataSource())
			.usersByUsernameQuery("select login as principal, mp as credentials from employe where login='admin'")
			.authoritiesByUsernameQuery("select login as principal, login as role from employe where login = 'admin'")
			.rolePrefix("ROLE_");*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.anyRequest()
				.permitAll()
			.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/index")
			.permitAll();		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**/*.css", "/**/*.png", "/**/*.gif", "/**/*.jpg");
	}
}
