package br.com.omarcoteixeira.architecture

import br.com.omarcoteixeira.architecture.enums.ArchitecturePackagesEnum
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import spock.lang.Shared
import spock.lang.Specification

import java.lang.Void as Should

import static com.tngtech.archunit.library.Architectures.layeredArchitecture

class LayerArchitectureTest extends Specification {

    @Shared
    def allClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages(ArchitecturePackagesEnum.BASE_PACKAGE.value)

    Should "layers have proper accesses"() {
        given:
        var rule = layeredArchitecture().consideringAllDependencies()
                .layer("UseCase").definedBy("..usecase..")
                .layer("Controller").definedBy("..controller..")
                .layer("Repository").definedBy("..repository..")
                .layer("DTO").definedBy("..data.dto..")
                .layer("Model").definedBy("..data.model..")
                .layer("Mapper").definedBy("..data.mapper..")
                .layer("Configuration").definedBy("..config..")
                .optionalLayer("Properties").definedBy("..config.properties..")
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("UseCase").mayOnlyBeAccessedByLayers("Controller", "Configuration")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("UseCase", "Configuration")
                .whereLayer("DTO").mayOnlyBeAccessedByLayers("Controller", "UseCase", "Mapper", "Configuration")
                .whereLayer("Model").mayOnlyBeAccessedByLayers("UseCase", "Repository", "Mapper", "Configuration")
                .whereLayer("Mapper").mayOnlyBeAccessedByLayers("Controller", "Configuration")
                .whereLayer("Properties").mayOnlyBeAccessedByLayers("Configuration", "Controller", "UseCase", "Repository")

        expect:
        rule.check(allClasses)
    }
}