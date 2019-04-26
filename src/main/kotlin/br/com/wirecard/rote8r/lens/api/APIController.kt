package br.com.wirecard.rote8r.lens.api

import br.com.moip.rote8r.routing.models.Mapping
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lens")
class APIController {

    @PostMapping
    fun create(@RequestBody mapping: Mapping): ResponseEntity<Any?> {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()
    }
}