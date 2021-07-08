import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.5.20"
	kotlin("plugin.spring") version "1.5.20"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}


repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	//implementation( "com.github.jkcclemens:khttp:0.1.0")
//	implementation( "config.build.gradle.kotlin")
//	implementation ("com.squareup.okhttp3:okhttp:3.4.2")
//	implementation ("com.squareup.okhttp:okhttp-urlconnection:2.0.0")
//	implementation ("com.squareup.okhttp3:okhttp:4.3.1")
//	developmentOnly ("com.github.jkcclemens:khttp:0.1.0")
	// https://mvnrepository.com/artifact/com.google.code.gson/gson
	implementation ("com.google.code.gson:gson:2.8.6")
	implementation ("org.apache.httpcomponents:httpclient:4.5.13")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("com.opencsv:opencsv:5.2")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	//runtimeOnly ("org.postgresql:postgresql")
	runtimeOnly  ("mysql:mysql-connector-java:8.0.18")
	 implementation( "org.jetbrains.kotlin:kotlin-noarg")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
