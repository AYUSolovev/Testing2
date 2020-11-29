package application.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfiguration {

    @Autowired
    AutowireCapableBeanFactory beanFactory;

    @Bean
    public FilterRegistrationBean securityServletAdmFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new SecurityAdmServletFilter());
        bean.addUrlPatterns("/question/adm/*","/test/delete/*");
        return bean;
    }

    @Bean
    public FilterRegistrationBean securityServletNormalFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new SecurityNormalServletFilter());
        bean.addUrlPatterns("/question/view/*","/test/view");
        return bean;
    }

    @Bean
    public ServletRegistrationBean servletAuthorizationNormalUser(){
        ServletRegistrationBean bean = new ServletRegistrationBean(
                new ServletAuthorizationNormalUser(),"/user/authorization");
        bean.setLoadOnStartup(1);
        return bean;
    }
}