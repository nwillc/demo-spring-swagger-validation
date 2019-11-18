package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
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

    @PostMapping("/ping1", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun ping1(@Valid @RequestBody ping: Ping1): ResponseEntity<Pong>
            = ResponseEntity(Pong(ping.ping), HttpStatus.OK)

    @PostMapping("/ping2", produces = [MediaType.APPLICATION_JSON_VALUE], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun ping2(@Valid @RequestBody ping: Ping2): ResponseEntity<Pong>
            = ResponseEntity(Pong(ping.ping), HttpStatus.OK)
}

data class Pong(@Min(1) val pong: Int)

data class Ping1(
    @Min(value = 1, message = "Must be at least 1")
    var ping: Int = 0
)

class Ping2 {
    @Min(value = 1, message = "Must be at least 1")
    var ping: Int = 0
}
