package br.com.omarcoteixeira.controller

import br.com.omarcoteixeira.specification.SpringSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class HealthControllerTest extends SpringSpecification {

    def "should return HTTP OK on /ping request"() {
        expect:
            def result = mockMvc.perform(
                get("/ping")
            ).andExpect {
                status().isOk()
            }.andReturn()
        and:
            result.getResponse().getContentAsString() == "false"
    }
}
