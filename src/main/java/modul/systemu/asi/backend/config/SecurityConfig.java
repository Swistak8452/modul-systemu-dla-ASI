package modul.systemu.asi.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("adebski@firma.pl").password("{noop}123456").roles("USER")
                .and()
                .withUser("mbycinski@firma.pl").password("{noop}123456").roles("USER")
                .and()
                .withUser("kzajac@firma.pl").password("{noop}123456").roles("USER", "ADMIN", "KIEROWNIK")
                .and()
                .withUser("jkowalski@firma.pl").password("{noop}123456").roles("USER")
                .and()
                .withUser("jpatyk@firma.pl").password("{noop}123456").roles("USER")
                .and()
                .withUser("wtyminski@firma.pl").password("{noop}123456").roles("USER", "ADMIN");
    }
}