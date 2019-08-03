group = "dev.afanasev"
version = "0.0.1"

plugins {
    `java-gradle-plugin`
    `maven-publish`
    id("com.gradle.plugin-publish") version "0.10.0"
    kotlin("jvm") version ("1.3.11")
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("gradle-plugin-api"))
    implementation("org.influxdb:influxdb-java:2.15")
}

gradlePlugin {
    plugins {
        create("vmOptionsPlugin") {
            id = "dev.afanasev.gradle-idea-vmoptions"
            implementationClass = "dev.afanasev.gradle.vmoptions.VMOptionsPlugin"
        }
    }
}