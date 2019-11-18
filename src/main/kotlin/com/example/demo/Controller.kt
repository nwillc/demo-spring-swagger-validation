package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.Min

@RestController
@Validated
class Controller {
    @GetMapping("/ping/{id}", produces = ["application/json"])
    fun ping(@Valid @Min(1) @PathVariable("id") id: Int): ResponseEntity<Pong>
            = ResponseEntity(Pong(id), HttpStatus.OK)

    @PostMapping("/ping", produces = ["application/json"], consumes = ["application/json"])
    fun ping(@Valid @RequestBody ping: Ping): ResponseEntity<Pong>
            = ResponseEntity(Pong(ping.ping), HttpStatus.OK)
}

data class Pong(@Min(1) val pong: Int)

data class Ping(
    @Min(value = 1, message = "Must be at least 1")
    var ping: Int
)
