package com.example.springboot_activiti.framework.security.config;

import com.example.springboot_activiti.framework.security.filter.JwtAuthenticationTokenFilter;
import com.example.springboot_activiti.framework.security.handle.*;
import com.example.springboot_activiti.framework.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConf extends WebSecurityConfigurerAdapter {

    @Resource
    CustomizeAuthenticationEntryPoint authenticationEntryPoint;
    //权限
    @Resource
    AccessFailureHandlerImpl accessFailureHandler;

    //登录成功
    @Resource
    LoginSuccessHandlerImpl loginSuccessHandler;

    //登录失败
    @Resource
    LoginFailureHandlerImpl loginFailureHandler;

    //退出
    @Resource
    LogoutSuccessHandlerImpl logoutSuccessHandler;

    //自定义用户逻辑
    @Resource
    UserDetailsServiceImpl userDetailsService;

    @Resource
    JwtAuthenticationTokenFilter authenticationTokenFilter;

    /**
     * 跨域过滤器
     */

    @Resource
    private CorsFilter corsFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置认证方式
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }




    /**
     * 配置web的拦截器
     *
     * @param http
     * @throws Exception
     */
    /**
     * anyRequest          |   匹配所有请求路径
     * access              |   SpringEl表达式结果为true时可以访问
     * anonymous           |   匿名可以访问
     * denyAll             |   用户不能访问
     * fullyAuthenticated  |   用户完全认证可以访问（非remember-me下自动登录）
     * hasAnyAuthority     |   如果有参数，参数表示权限，则其中任何一个权限可以访问
     * hasAnyRole          |   如果有参数，参数表示角色，则其中任何一个角色可以访问
     * hasAuthority        |   如果有参数，参数表示权限，则其权限可以访问
     * hasIpAddress        |   如果有参数，参数表示IP地址，如果用户IP和参数匹配，则可以访问
     * hasRole             |   如果有参数，参数表示角色，则其角色可以访问
     * permitAll           |   用户可以任意访问
     * rememberMe          |   允许通过remember-me登录的用户访问
     * authenticated       |   用户登录后可访问
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭csrf保护功能
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/login", "/toLogin", "/captchaImage").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessFailureHandler)
                //匿名登录
                .authenticationEntryPoint(authenticationEntryPoint)
                .and()
                //基于token,不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//                .formLogin()
//                .successHandler(loginSuccessHandler)
//                .failureHandler(loginFailureHandler)
//                .permitAll()
//                .and()
                .logout()
                .logoutUrl("/logout")
                //退出成功，返回json
                .logoutSuccessHandler(logoutSuccessHandler)
                .permitAll();
        // 添加JWT filter
        http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        // 添加CORS filter
        http.addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class);
        http.addFilterBefore(corsFilter, LogoutFilter.class);
    }


    /**
     * 密码生成策略.
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
