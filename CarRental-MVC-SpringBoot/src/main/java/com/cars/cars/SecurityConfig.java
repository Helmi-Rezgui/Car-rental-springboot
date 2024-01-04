package com.cars.cars;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Admin")
                .password("Admin")
                .roles("User","Admin")
                .and()
                .withUser("User")
                .password("User")
                .roles("User");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }





    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/cars").hasAnyRole("User","Admin")
                .antMatchers("/orders/**").hasAnyRole("User","Admin")
                .antMatchers("/bookingform/**").hasAnyRole("User","Admin")
                .antMatchers("/admin/add-vehicle").hasAnyRole("Admin")
                .antMatchers("/new-customer/**").hasAnyRole("Admin")
                .antMatchers("/update-booking/**").hasAnyRole("User","Admin")
                .antMatchers("/update-car/**").hasAnyRole("Admin")
                .antMatchers("/update-customer/**").hasAnyRole("Admin")
                .antMatchers("/error-delete").hasAnyRole("Admin")
                .antMatchers("/customers/**").hasAnyRole("Admin")
                .antMatchers("/admin/**").hasAnyRole(("Admin"))
                .antMatchers("/admin/vehicles").hasAnyRole("Admin")
                .antMatchers("/admin/customers").hasAnyRole("Admin")

                .and().formLogin()
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");


    }
}

