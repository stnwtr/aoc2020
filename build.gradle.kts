plugins {
    java
    kotlin("jvm") version "1.4.20"
    application
}

group = "at.stnwtr"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

application.mainClassName = "at.stnwtr.aoc2020.LauncherKt"
