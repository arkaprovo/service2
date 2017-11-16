package com.sath.devops.service2

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class Service2Application

fun main(args: Array<String>) {
    SpringApplication.run(Service2Application::class.java, *args)
}
