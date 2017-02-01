package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()  //设置"/"和"/home"下的网页不需要验证
                .anyRequest().authenticated()                       //其他网页都需要验证
                .and()
                .formLogin()
                .loginPage("/login")          //任何人都允许查看登陆界面，当进入需要验证的网站时将自动跳入登陆界面
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    /*提供一个用户名为"user"，密码为"password"，角色名为"USER"的用户*/
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}