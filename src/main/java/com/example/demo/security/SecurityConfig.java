package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email as principal,password as credentials, etat FROM user WHERE email=?")
                .authoritiesByUsernameQuery("SELECT u.email as principal , r.nom as role FROM user u, roles r, user_roles ur WHERE u.id=ur.idu AND r.id = ur.idr AND u.email= ?")
                .rolePrefix("ROLE-") ;

    }
    @Override
    protected void configure(HttpSecurity http){
        //http.formLogin() pour afficher un formulaire de login par defaut
        try {
            http.formLogin().loginPage("/login");//personnaliser le form de login
            // les Droits d'un ADMIN
            http.authorizeRequests().antMatchers("/Lieu/**").hasRole("ADMIN");
            //les Droits du role DE
            http.authorizeRequests().antMatchers("/Formation/**").hasRole("DE");
            // les Droits du roile SUPERADMIN
            http.authorizeRequests().antMatchers( "/User/**", "/Roles/**").hasRole("SUPERADMIN");
            //gestion des droits
            http.exceptionHandling().accessDeniedPage("/Admin/403");
            http.csrf().disable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
