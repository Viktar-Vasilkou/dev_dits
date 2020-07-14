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

    private  CustomSuccessHandler customSuccessHandler;
    private  PasswordEncoder passwordEncoder;
    private  DataSource dataSource;

    public SecurityConfiguration(){

    }

    @Autowired
    public void setCustomSuccessHandler(CustomSuccessHandler customSuccessHandler) {
        this.customSuccessHandler = customSuccessHandler;
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

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
                .dataSource(getDataSource())
                .passwordEncoder(getPasswordEncoder())
                .usersByUsernameQuery("select login as username, password, true from user where login=?")
                .authoritiesByUsernameQuery(
                        "SELECT users.login as username, roles.name as role " +
                        "        FROM users " +
                        "        INNER JOIN userrole ON users.id = userrole.userId " +
                        "        INNER JOIN roles ON userrole.roleId = roles.id" +
                        "        WHERE users.login = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/", "/index", "/home").permitAll()
            .antMatchers("/user/**").access("hasRole('USER')")
            .antMatchers("/admin/**").access("hasRole('ADMIN')")
            .antMatchers("/tutor/**").access("hasRole('TUTOR')");

        http
            .formLogin()
            .loginPage("/login")
            .usernameParameter("login")
            .passwordParameter("password")
            .successHandler(getCustomSuccessHandler());

        http
            .csrf();

        http
            .exceptionHandling()
            .accessDeniedPage("/accessDenied");

        http
            .logout()
            .logoutSuccessUrl("/logout")
            .permitAll();
    }
}
