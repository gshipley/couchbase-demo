package com.openshift.couchbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    Environment environment;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("data/**")
        .addResourceLocations("file:" + environment.getProperty("media"));
    }
}
