buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.11.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0")
        classpath("io.realm:realm-gradle-plugin:10.19.0")
        classpath("com.google.gms:google-services:4.4.3")
        classpath("com.google.firebase:firebase-crashlytics-gradle:3.0.4")
        classpath("com.google.firebase:perf-plugin:1.4.2")
        classpath("org.jetbrains.kotlin:compose-compiler-gradle-plugin:2.2.0")
    }
}
