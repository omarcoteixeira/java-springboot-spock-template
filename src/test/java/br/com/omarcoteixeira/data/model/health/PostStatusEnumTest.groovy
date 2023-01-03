package br.com.omarcoteixeira.data.model.health

import br.com.omarcoteixeira.data.model.post.PostStatusEnum
import spock.lang.Specification

class PostStatusEnumTest extends Specification {

    def "PostEnum Should have all values"() {
        expect:
            Objects.equals(enumMember.getCode(), statusValue) == expectedResult
        where:
            enumMember              | statusValue   | expectedResult
            PostStatusEnum.DRAFT     | 0 | true
            PostStatusEnum.PUBLISHED | 1 | true
            PostStatusEnum.ARCHIVED  | 2 | true
    }

}
