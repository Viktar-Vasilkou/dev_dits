package by.devincubator.vasilkou.dits.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan("by.devincubator.vasilkou.dits")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomSuccessHandler customSuccessHandler;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DataSource dataSource;

    @Bean
    public CustomSuccessHandler getCustomSuccessHandler() {
        return new CustomSuccessHandler();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery("select login as username, password, true from user where login=?")
                .authoritiesByUsernameQuery(
                        "SELECT users.login as username, roles.name as role \n" +
                        "        FROM users \n" +
                        "        INNER JOIN userrole ON users.id = userrole.userId \n" +
                        "        INNER JOIN roles ON userrole.roleId = roles.id\n" +
                        "        WHERE users.login = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/", "/user/**").access("hasRole('USER')")
            .antMatchers("/admin/**").access("hasRole('ADMIN')")
            .antMatchers("/tutor/**").access("hasRole('TUTOR')");

        http
            .formLogin()
            .loginPage("/login")
            .successHandler(getCustomSuccessHandler())
            .usernameParameter("login")
            .passwordParameter("password")
            .permitAll();

        http
            .csrf();

        http
            .exceptionHandling()
            .accessDeniedPage("/accessDenied");

        http
            .logout()
            .permitAll();
    }
}
