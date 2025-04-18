package com.chrispie

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChrispieApplication

fun main(args: Array<String>) {
    runApplication<ChrispieApplication>(*args)
}
