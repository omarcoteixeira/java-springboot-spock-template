package br.com.omarcoteixeira;

import br.com.omarcoteixeira.config.ApplicationConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

// @SpringBootApplication
@Import({ApplicationConfiguration.class})
public class ApplicationStarter extends SpringBootServletInitializer {

  public static void main(String[] args) {
    new SpringApplicationBuilder(ApplicationStarter.class)
        .profiles("spring.config.name:app")
        .build()
        .run(args);
  }
}
