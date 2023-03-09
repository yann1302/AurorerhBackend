package com.advance.aurore_rh.config;

import com.advance.aurore_rh.service.auth.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;

@EnableWebSecurity


public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ApplicationUserService applicationUserService;

    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(applicationUserService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable()
              .authorizeHttpRequests()
              .antMatchers(
                      "/swagger-ui.html",
                      "/v2/api-docs",
                      "/**/swagger-resources/**",
                      "/configuration/ui",
                      "/webjars/**" ,
                      "/employer/**",
                      "/contrat/**",
                      "/sanction/**",
                      "/conger/**",
                      "/type de contrat/**",
                      "/auth/**")
              .permitAll()
              .anyRequest()
              .authenticated();
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.httpFirewall(new DefaultHttpFirewall());
//    }


    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }
}
