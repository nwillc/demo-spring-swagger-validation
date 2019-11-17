package com.example.demo

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import javax.validation.constraints.Min

@RestController
@Validated
class Controller {
    @GetMapping("/ping/{id}")
    fun ping(@Valid @PathVariable @Min(1) id: Int): String {
        return "pong: $id"
    }
}
