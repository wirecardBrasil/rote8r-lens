import org.gradle.api.credentials.PasswordCredentials
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "br.com.wirecard"
version = "1.0-SNAPSHOT"

buildscript {
    var springBootVersion : String by extra
    var artifactoryUsername: String by extra //TODO replace with gradle.properties
    var artifactoryPassword: String by extra //TODO replace with gradle.properties

    springBootVersion = "2.0.0.RELEASE"
    artifactoryUsername = "developer"
    artifactoryPassword = "AP5xrUuUbJEha1sZCWpJqDABhwA"
}

val springBootVersion: String by extra
val artifactoryUsername: String by extra
val artifactoryPassword: String by extra

repositories {

    val credentials: (org.gradle.api.artifacts.repositories.PasswordCredentials).() -> Unit = {
        username = "${artifactoryUsername}"
        password = "${artifactoryPassword}"
    }

    maven(url = "https://moip.artifactoryonline.com/moip/libs-release").credentials(credentials)
    maven(url = "https://moip.artifactoryonline.com/moip/libs-snapshot").credentials(credentials)
    maven(url = "https://moip.artifactoryonline.com/moip/plugins-release").credentials(credentials)
    maven(url = "https://moip.artifactoryonline.com/moip/plugins-snapshot").credentials(credentials)

    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.jetbrains.kotlin:kotlin-reflect")
    compile("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
    compile("br.com.moip.rote8r:core:1.0.2")
    compile("br.com.moip.rote8r:mongo-repository:1.0.2")
    compile("de.flapdoodle.embed:de.flapdoodle.embed.mongo:2.2.0")

    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

plugins {
    java
    kotlin("jvm") version "1.2.51"
    id("org.springframework.boot") version "2.1.4.RELEASE"
}

springBoot {
    mainClassName = "br.com.wirecard.rote8r.lens.ApplicationKt"
}