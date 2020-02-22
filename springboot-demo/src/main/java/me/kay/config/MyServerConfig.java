package me.kay.config;

import me.kay.filter.MyFilter;
import me.kay.listener.MyListener;
import me.kay.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class MyServerConfig {

//    public ServletWebServerFactoryCustomizer servletWebServerFactoryCustomizer() {
//        return new ServletWebServerFactoryCustomizer(){
//
//        };
//    }
//    @Bean
//    public TomcatServletWebServerFactoryCustomizer tomcatServletWebServerFactoryCustomizer(){
//        TomcatServletWebServerFactoryCustomizer customizer = new TomcatServletWebServerFactoryCustomizer();
//    }

    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new MyServlet());
        bean.setUrlMappings(Collections.singletonList("/myServlet"));
        bean.setLoadOnStartup(0);
        return bean;
    }

    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter());
        bean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return bean;
    }

    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean<MyListener> bean = new ServletListenerRegistrationBean<>();
        bean.setListener(new MyListener());
        return bean;
    }
}
