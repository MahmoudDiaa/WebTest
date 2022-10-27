import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test"))
    implementation("io.ktor:ktor-server-core:2.1.2")
    implementation("io.ktor:ktor-server-netty:2.1.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.ktor:ktor-client-core:2.1.2")
    implementation("io.ktor:ktor-serialization-jackson:2.1.2")
    implementation("ch.qos.logback:logback-classic:1.4.4")
    implementation("io.ktor:ktor-server-content-negotiation:2.1.2")

    testImplementation("io.ktor:ktor-server-test-host:2.1.2")
    testImplementation("io.ktor:ktor-client-mock:2.1.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}