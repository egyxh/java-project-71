plugins {
    application
    id("checkstyle")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("com.diffplug.spotless") version "6.25.0"
    id("jacoco")
    id("org.sonarqube") version "6.2.0.5505"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    applicationName = "app"
    mainClass.set("hexlet.code.App")
}

tasks.compileJava {
    options.compilerArgs.add("-Aproject=${project.group}/${project.name}")
}

dependencies {

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
    implementation("info.picocli:picocli:4.7.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
    annotationProcessor("info.picocli:picocli-codegen:4.7.7")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.build {
    dependsOn(tasks.clean)
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
}

tasks.withType<Checkstyle> {
    configFile = file("config/checkstyle/checkstyle.xml")
    ignoreFailures = false
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
        html.required.set(true)
        csv.required.set(false)
    }
}

sonar {
    properties {
        property("sonar.projectKey", "egyxh_java-project-71")
        property("sonar.organization", "egyxh")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}
