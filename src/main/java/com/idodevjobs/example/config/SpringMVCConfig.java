package com.idodevjobs.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.idodevjobs.example")
@Import({SpringDBConfig.class})
@EnableWebMvc
public class SpringMVCConfig {}