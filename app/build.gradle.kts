plugins {
    id("application")
    id("checkstyle")
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

checkstyle {
    // Use the version of Checkstyle you want
    toolVersion = "11.1.0"

    // Optional: point to your custom config
    configFile = file("$rootDir/config/checkstyle.xml")
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}
