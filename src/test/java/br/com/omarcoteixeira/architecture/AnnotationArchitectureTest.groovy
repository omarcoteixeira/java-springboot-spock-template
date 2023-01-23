package br.com.omarcoteixeira.architecture

import br.com.omarcoteixeira.architecture.enums.ArchitecturePackagesEnum
import com.tngtech.archunit.base.DescribedPredicate
import com.tngtech.archunit.core.domain.JavaAnnotation
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RestController
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.lang.Void as Should

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.constructors
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods

class AnnotationArchitectureTest extends Specification {

    @Shared
    def allClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages(ArchitecturePackagesEnum.BASE_PACKAGE.value)

    static final String[] PACKAGES_ALLOWED_IN_DOMAIN = [
            "org.slf4j",
            "lombok",
            "com.google.common",
            "java",
            "org.springframework.stereotype",
            "org.mapstruct"
    ]

    Should "#SUFFIX classes from '#PACKAGE' have proper annotation"() {
        given:
            def rule = ArchRuleDefinition.classes().that()
                    .resideInAnyPackage(PACKAGE)
                    .and()
                    .haveSimpleNameEndingWith(SUFFIX)
                    .should().beAnnotatedWith(CLASS)
        expect:
            rule.check(allClasses)
        where:
            PACKAGE             || SUFFIX           || CLASS
            "..config.."        || 'Configuration'  || Configuration.class
            "..repository.."    || 'Impl'           || Repository.class
            "..repository.."    || 'Repository'     || FunctionalInterface.class
            "..usecase.."       || 'Impl'           || Service.class
            "..usecase.."       || 'UseCase'        || FunctionalInterface.class
            "..controller.."    || 'Controller'     || RestController.class
    }

    Should "all interfaces (except mapper) have @FunctionalInterface annotation"() {
        given:
        def rule = ArchRuleDefinition.classes().that()
                .areInterfaces()
                .and()
                .haveSimpleNameNotEndingWith("Mapper")
                .should().beAnnotatedWith(FunctionalInterface.class)
        expect:
        rule.check(allClasses)
    }

    @Unroll
    Should 'autowired annotations are not used on #DESCRIPTION'() {
        given:
            def rule = CODE_UNIT.should()
                .notBeAnnotatedWith(Autowired.class)
        expect:
            rule.check(allClasses)
        where:
            CODE_UNIT      || DESCRIPTION
            constructors() || 'constructors'
            fields()       || 'fields'
            methods()      || 'methods'
    }

    Should 'data objects use only specified packages'() {
        given:
        def rule = ArchRuleDefinition.classes()
                .that()
                    .resideInAnyPackage("..data..")
                .should()
                .notBeAnnotatedWith(
                    getOtherAnnotations(
                        "annotations from packages other than: $PACKAGES_ALLOWED_IN_DOMAIN",
                        PACKAGES_ALLOWED_IN_DOMAIN
                    )
                )
        expect:
        rule.check(allClasses)
    }

    DescribedPredicate<JavaAnnotation> getOtherAnnotations(String description, String[] allowedPackages) {
        return new DescribedPredicate<JavaAnnotation>(description) {
            @Override
            boolean test(JavaAnnotation javaAnnotation) {
                return !allowedPackages.any {
                    javaAnnotation.rawType.packageName.startsWith(it)
                }
            }
        }
    }
}