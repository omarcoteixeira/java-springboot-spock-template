package br.com.omarcoteixeira.data.model.health

import br.com.omarcoteixeira.data.model.post.PostStatusEnum
import spock.lang.Specification

import java.lang.Void as Should

class PostStatusEnumTest extends Specification {

    Should "PostEnum have #MEMBER"() {
        expect:
            Objects.equals(MEMBER.getCode(), VALUE) == EXPECTED
        where:
            MEMBER                   | VALUE            | EXPECTED
            PostStatusEnum.DRAFT     | 0                | true
            PostStatusEnum.PUBLISHED | 1                | true
            PostStatusEnum.ARCHIVED  | 2                | true
    }

}
