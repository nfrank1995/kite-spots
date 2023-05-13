package de.nfrank.kitespots

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KiteSpotsApplication

fun main(args: Array<String>) {
    runApplication<KiteSpotsApplication>(*args)
}
