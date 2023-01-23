package br.com.omarcoteixeira.architecture

import br.com.omarcoteixeira.architecture.enums.ArchitecturePackagesEnum
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import spock.lang.Shared
import spock.lang.Specification

import java.lang.Void as Should

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*

class FieldsArchitectureTest extends Specification {

    @Shared
    def allClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages(ArchitecturePackagesEnum.BASE_PACKAGE.value)

    Should 'all fields should be private'() {
        given:
        def rule = fields()
                .that().areDeclaredInClassesThat().areNotEnums()
                .should().bePrivate()
        expect:
        rule.check(allClasses)
    }
}