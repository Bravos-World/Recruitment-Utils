plugins {
    java
    id("java-library")
    id("maven-publish")
}

group = "com.bravos.recruitment.libs"
version = "1.0.2"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.44")
    annotationProcessor("org.projectlombok:lombok:1.18.44")

    // Source: https://mvnrepository.com/artifact/tools.jackson.core/jackson-databind
    api("tools.jackson.core:jackson-databind:3.1.0")

    // Source: https://mvnrepository.com/artifact/tools.jackson.core/jackson-core
    api("tools.jackson.core:jackson-core:3.1.0")
}

publishing {
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}