package me.kay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

//@EnableWebMvc // 全面接管MVC的配置， 默认的MVC自动配置全部失效
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("kay").setViewName("success");

                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor())
//                        .addPathPatterns("/**")
//                        // Exclude Path
//                        .excludePathPatterns("/index.html")
//                        .excludePathPatterns("/")
//                        .excludePathPatterns("/user/login")
//                        .excludePathPatterns("/webjars/**")
//                        .excludePathPatterns("/asserts/**");
//                registry.addInterceptor(localeChangeInterceptor());
            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
            }


        };
        return configurer;
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        // 参数名
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

}
