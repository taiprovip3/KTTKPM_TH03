package com.example.spring_boot_api_jwt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "templates/**", "/img/**", "/css/**", "/js/**", "/jQuery/**", "/product-img/**");
	}
	
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/register", "/login").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN");
        http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler()).and()
        .exceptionHandling().authenticationEntryPoint(new CustomHttp403ForbiddenEntryPoint());
    }
    

}
