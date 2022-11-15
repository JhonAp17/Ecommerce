
package com.examen.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
       auth.inMemoryAuthentication()
               .withUser("admin")
                    .password("{noop}123")
                    .roles("ADMIN","COMPRADOR")
               .and()
               .withUser("comprador")
                    .password("{noop}123")
                    .roles("COMPRADOR");
    }
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests()
                .antMatchers("/agregar/**", "/editar/**", "/eliminar/**")
                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("COMPRADOR", "ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login") 
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    }
        
    
        
        
}
