plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
	id("com.netflix.dgs.codegen") version "6.2.1"
	kotlin("kapt") version "1.7.21"

}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
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

extra["netflixDgsVersion"] = "9.1.3"

dependencies {
	implementation("com.netflix.graphql.dgs:graphql-dgs-spring-graphql-starter")
	implementation("com.netflix.graphql.dgs.codegen:graphql-dgs-codegen-gradle:6.3.0")
	implementation("com.netflix.graphql.dgs:graphql-dgs-extended-scalars")
//	implementation ("com.netflix.graphql.dgs:graphql-dgs-subscriptions-websockets-autoconfigure:latest.release")
	implementation("org.springframework.boot:spring-boot-starter-websocket")
	implementation("org.ocpsoft.prettytime:prettytime:5.0.8.Final")
	implementation("org.bouncycastle:bcprov-jdk15on:1.68")


	implementation("net.datafaker:datafaker:2.4.1")

	implementation("com.graphql-java:graphql-java-extended-scalars:22.0")

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.projectlombok:lombok")

	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	runtimeOnly("org.postgresql:postgresql")

	implementation("org.mapstruct.extensions.spring:mapstruct-spring-annotations:0.1.2")
	implementation("org.mapstruct:mapstruct:1.5.3.Final")
	kapt("org.mapstruct:mapstruct-processor:1.5.3.Final")
}

dependencyManagement {
	imports {
		mavenBom("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:${property("netflixDgsVersion")}")
	}
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.generateJava {

	packageName = "com.example.assignment.codegen"
	generateClient = true
	typeMapping = mutableMapOf(
		"DateScalar" to  "java.time.LocalDate",
		"Url" to  "java.net.URL",

		)

}



tasks.withType<Test> {
	useJUnitPlatform()
}
