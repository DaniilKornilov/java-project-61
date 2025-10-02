plugins {
    id("application")
    id("com.github.ben-manes.versions") version "0.53.0"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("hexlet.code.App")
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}
