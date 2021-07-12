package com.example.demo

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
@EnableAutoConfiguration
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

