package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication //(scanBasePackages = ["org.bitbucket.tek.nik.simplifiedswagger", "com.example.demo"])
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
