package br.com.omarcoteixeira.data.model.metrics

import spock.lang.Specification

class MetricsEnumTest extends Specification {

    def "MetricsEnum Should have all values"() {
        expect:
            Objects.equals(enumMember.name, nameValue) == expectedResult
            Objects.equals(enumMember.description, descriptionValue) == expectedResult
        where:
            enumMember                  | nameValue     | descriptionValue      | expectedResult
            MetricsEnum.IS_HEALTHY      | "is_healthy"  | "Is app healthy"      | true
            MetricsEnum.HTTP_HEALTHY    | "http_health" | "Is http healthy"     | true
    }

}
