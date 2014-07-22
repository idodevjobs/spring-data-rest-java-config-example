package com.idodevjobs.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryRestDispatcherServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
public class WebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
        rootCtx.register(SpringMVCConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootCtx));
        ServletRegistration.Dynamic reg = servletContext.addServlet("rest", RepositoryRestDispatcherServlet.class);
        reg.setLoadOnStartup(1);
        reg.addMapping("/api/*");
    }
}