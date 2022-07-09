plugins {
    id("java")
}

group = "com.dfsek"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://papermc.io/repo/repository/maven-public/") {
        name = "PaperMC"
    }
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    compileOnly("io.papermc.paper:paper-api:1.19-R0.1-SNAPSHOT")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}