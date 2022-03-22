package com.oleg.el.auto.save.data

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

//TODO The source of example is
@SpringBootApplication
//@ComponentScan("com.oleg.el.auto.save.data.repository")
class Application

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
