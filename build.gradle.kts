plugins {
	java
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-devtools")
	implementation("com.h2database:h2")
	implementation("org.hamcrest:hamcrest:3.0")
	implementation("org.apache.commons:commons-lang3:3.0")
	implementation("com.fasterxml.jackson.core:jackson-core:2.18.3")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.18.3")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
