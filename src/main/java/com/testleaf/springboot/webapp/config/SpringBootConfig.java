/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testleaf.springboot.webapp.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.testleaf.springboot.webapp")
public class SpringBootConfig {
    
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(SpringBootConfig.class)
                .run();
    }
    
}
