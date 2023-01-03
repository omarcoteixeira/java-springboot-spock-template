package br.com.omarcoteixeira.controller

import br.com.omarcoteixeira.data.model.user.User
import br.com.omarcoteixeira.specification.SpringSpecification
import br.com.omarcoteixeira.usecase.user.GetUserByIdUseCase
import org.spockframework.spring.SpringBean
import spock.lang.Shared

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class UserControllerTest extends SpringSpecification {

    @Shared
    User expectedUser = [
            id  : UUID.randomUUID().toString(),
            name: "Testing"
    ] as User

    @SpringBean
    GetUserByIdUseCase getUserByIdUseCase = Mock(GetUserByIdUseCase)

    def "should return return a user by specified id"() {
        when:
        def result = mockMvc.perform(get("/user/" + expectedUser.id))
        def response = result.andReturn().response

        then:
        1 * getUserByIdUseCase.execute(expectedUser.id) >> expectedUser
        with(objectMapper.readValue(response.contentAsString, User)) {
            it == expectedUser
        }
    }

    def "should return return a user by specified i2d"() {
        when:
        def result = mockMvc.perform(get("/user/" + expectedUser.id))
        def response = result.andReturn().response

        then:
        1 * getUserByIdUseCase.execute(expectedUser.id) >> expectedUser
        with(objectMapper.readValue(response.contentAsString, User)) {
            it == expectedUser
        }
    }
}
