package com.analyticssakha;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.analyticssakha")
@EnableAspectJAutoProxy
public class BeanConfig {
}
