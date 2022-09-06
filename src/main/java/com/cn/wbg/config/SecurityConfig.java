package com.cn.wbg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author xiaoliu
 * @ClassName SecutityConfig
 * @date 2021/11/1 10:48
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {




    /* 注入 UserDetailsService 对象 */
    @Autowired
    private UserDetailsService userService;


    /**
     * 设置登录账号
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwrod());
    }
    /**
     * 自定义页面，页面拦截
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.logout().logoutUrl("/toLogout").logoutSuccessUrl("/toLogin").permitAll();
        http.exceptionHandling().accessDeniedPage("/to403");
        http.formLogin()
                .loginPage("/toLogin") // 去往登录页面
                .loginProcessingUrl("/login") // 登录表单提交路径
                .defaultSuccessUrl("/toIndex").permitAll() // 默认登陆成功跳转的页面
                .and().authorizeRequests() // 所有请求都要验证
                .antMatchers("/login","/main",
                        "/comment/queryusername",
                        "/com/**","/toregister","/register","/toIndex").permitAll() // 放行登录请求和静态资源
//                .antMatchers("/toHappy").hasAuthority("ADMIN")
//                .antMatchers("/aa").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated() // 认证后放行所有请求
                .and().csrf().disable(); // 跨站请求伪造，关闭 csrf 防护
        // CSRF（Cross-site request forgery跨站请求伪造，也被称为“One Click Attack”或者Session Riding，
        // 通常缩写为CSRF或者XSRF，是一种对网站的恶意利用。为了防止跨站提交攻击，通常会配置csrf。
        // 如果不采用csrf，可禁用security的csrf，如果不禁用，项目中启用了 security，post请求无法通过
    }


    /**
     * 告知 Spring 密码的认证方式
     *
     * @return
     */
    @Bean
    PasswordEncoder passwrod() {
        return new BCryptPasswordEncoder();
    }


}
