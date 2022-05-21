package com.lock_redis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LockRedisApplication

fun main(args: Array<String>) {
	runApplication<LockRedisApplication>(*args)
}
