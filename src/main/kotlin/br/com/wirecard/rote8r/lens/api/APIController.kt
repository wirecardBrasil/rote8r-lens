package br.com.wirecard.rote8r.lens.api

import br.com.moip.rote8r.routing.models.Mapping
import br.com.moip.rote8r.routing.service.RoutingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lens")
class APIController {

    private var routingService: RoutingService

    @Autowired constructor(routingService: RoutingService) {
        this.routingService = routingService
    }

    @PostMapping
    fun route(@RequestBody mapping: Mapping): ResponseEntity<Any?> {
        val routed = routingService.route(mapping)
        return ResponseEntity.status(HttpStatus.OK).body(routed)
    }
}