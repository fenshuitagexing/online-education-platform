package net.xdclass.online_xdclass.config;

import net.xdclass.online_xdclass.interceptor.SignInInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The path can be accessed without signing in: /api/v1/pub
 * The path required to be accessed through signing in: /api/v1/pri
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    SignInInterceptor signInInterceptor() {
        return new SignInInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInInterceptor())
                .addPathPatterns("/api/v1/pri/**")
                .excludePathPatterns("/api/v1/pri/user/sign_up", "/api/v1/pri/user/sign_in");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
