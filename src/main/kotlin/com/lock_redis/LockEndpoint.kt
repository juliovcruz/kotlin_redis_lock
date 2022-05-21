package com.lock_redis

import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.config.Config
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.concurrent.TimeUnit

@RestController
@RequestMapping("/")
class LockEndpoint(
    private val redisson: RedissonClient? = Redisson.create(Config().also {
        it.useSingleServer()
            .setPassword("redis").address = "redis://localhost:6379"
    })
) {

    @PostMapping("/lock/{key}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun lock(@RequestParam sleep: Long, @PathVariable key: String) {
        val lock = this.redisson!!.getLock(key)

        if(!lock.tryLock(1, TimeUnit.SECONDS)) {
            throw ResponseStatusException(HttpStatus.PRECONDITION_FAILED)
        }

        Thread.sleep(sleep * 1000)

        lock.unlockAsync()
    }
}