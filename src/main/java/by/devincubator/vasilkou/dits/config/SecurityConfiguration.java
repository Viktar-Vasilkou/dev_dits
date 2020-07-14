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
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.sql.DataSource;

@EnableWebSecurity
@ComponentScan("by.devincubator.vasilkou.dits")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Bean
    public CustomSuccessHandler getCustomSuccessHandler(){
        return new CustomSuccessHandler();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public  PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
                auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery("select login, password, 1 " +
                        "from users where login=?")
                .authoritiesByUsernameQuery(
                        "SELECT login, name " +
                        "FROM users " +
                        "JOIN userrole ON users.id = userId " +
                        "JOIN roles ON roleId = roles.id " +
                        "WHERE login=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        http
            .authorizeRequests()
            .antMatchers("/", "/index").permitAll()
            .antMatchers("/user/**").access("hasRole('USER')")
            .antMatchers("/admin/**").access("hasRole('ADMIN')")
            .antMatchers("/tutor/**").access("hasRole('TUTOR')")
            .antMatchers( "/home").access("hasAnyRole('USER', 'ADMIN', 'TUTOR')");

        http
            .formLogin()
            .loginPage("/login")
            .failureUrl("/login?error")
            .loginProcessingUrl("/login")
            .usernameParameter("j_login")
            .passwordParameter("j_password")
            .successHandler(getCustomSuccessHandler())
            .permitAll();

        http
            .csrf();

        http
            .exceptionHandling()
            .accessDeniedPage("/accessDenied");

        http
            .logout()
            .permitAll()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .invalidateHttpSession(true);

        http
            .addFilterBefore(filter, CsrfFilter.class);
    }
}
