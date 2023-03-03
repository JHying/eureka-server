package tw.hyin.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author JHying(Rita) on 2022.
 * @description
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    //新版的 eureka (3.1.4) 預設開啟 csrf 認證，需手動設定 security 改由帳密登入，否則無法連線註冊
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and().build();
    }
}
