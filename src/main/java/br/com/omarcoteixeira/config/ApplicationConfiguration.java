package br.com.omarcoteixeira.config;

import org.springframework.boot.actuate.autoconfigure.endpoint.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementContextAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@Import({
  ManagementContextAutoConfiguration.class,
  EndpointAutoConfiguration.class,
  WebEndpointAutoConfiguration.class,
  ServletWebServerFactoryAutoConfiguration.class,
  DispatcherServletAutoConfiguration.class,
  MetricsConfiguration.class,
  HealthConfiguration.class,
  RepositoryConfiguration.class,
  UseCaseConfiguration.class
})
@ComponentScan(
    basePackages = {"br.com.omarcoteixeira.controller", "br.com.omarcoteixeira.data.mapper"})
public class ApplicationConfiguration {}
