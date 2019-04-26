package br.com.wirecard.rote8r.lens

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration

@SpringBootApplication(exclude = [
    MongoAutoConfiguration::class,
    MongoDataAutoConfiguration::class])
open class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}