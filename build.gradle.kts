import org.asciidoctor.gradle.editorconfig.AsciidoctorEditorConfigGenerator
import org.asciidoctor.gradle.jvm.AsciidoctorTask

plugins {
    id("org.asciidoctor.editorconfig") version "4.0.2"
    id("org.asciidoctor.jvm.convert") version "4.0.2"
    id("org.asciidoctor.jvm.gems") version "4.0.2"
}

repositories {
    ruby {
        gems()
    }
    gradlePluginPortal()
}

buildscript {
    configurations.classpath {
        resolutionStrategy.force("org.ysb33r.gradle:grolifant-core:3.0.1")
    }
}

dependencies {
    asciidoctorGems("rubygems:asciidoctor-interdoc-reftext:0.5.3")

    configurations.all {
        resolutionStrategy {
            force(
                //TODO:: 1. When setting it to 9.3.14.0 it works and 9.4.7.0 not
                //"org.jruby:jruby:9.3.14.0"
                "org.jruby:jruby:9.4.7.0"
            )
        }
    }
}

asciidoctorj {
    requires("asciidoctor-interdoc-reftext")
    //TODO:: 2. When setting it to 9.3.14.0 it works and 9.4.7.0 not
    //setJrubyVersion("9.3.14.0")
    setJrubyVersion("9.4.7.0")
}

val editorConfigTaskProvider =
    tasks.named<AsciidoctorEditorConfigGenerator>("asciidoctorEditorConfig") {
        group = "documentation"
        additionalAttributes(asciidoctorj)
        setDestinationDir(rootDir)
    }

val asciidoctorTaskProvider = tasks.named<AsciidoctorTask>("asciidoctor") {
    group = "documentation"
    baseDirFollowsSourceFile()
    sourceDir(rootDir)
    sources {
        include("**/*.adoc")
        exclude("**/build/**/*")
    }
    resources {
        from(sourceDir) {
            include("**/*.png")
            exclude("**/build/**/*")
        }
        includeEmptyDirs = false
    }
    setFailureLevel("INFO")
    withGemJar("asciidoctorGemsJar")
    dependsOn("asciidoctorGemsPrepare", "asciidoctorGemsJar")
}
