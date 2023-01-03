package br.com.omarcoteixeira.specification

import br.com.omarcoteixeira.config.ApplicationConfiguration
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfiguration,  initializers = [ConfigDataApplicationContextInitializer])
class SpringSpecification extends Specification {

    @Shared
    MockMvc mockMvc

    @Autowired
    WebApplicationContext webApplicationContext

    ObjectMapper objectMapper = new ObjectMapper()

    def setup() {
        mockMvc = webAppContextSetup(webApplicationContext).build()
    }
}
