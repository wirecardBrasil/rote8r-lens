package br.com.wirecard.rote8r.lens.config

import br.com.moip.rote8r.routing.repositories.MongoDBRuleRepository
import br.com.moip.rote8r.routing.service.RoutingRuleRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import br.com.moip.rote8r.routing.service.RoutingService


@Configuration
open class RoutingConfiguration {

    val user = "user"
    val password = "password"

    @Bean
    open fun routingRuleRepository(): RoutingRuleRepository {
        return MongoDBRuleRepository(
                "mongodb://${user}:${password}@ds027345.mlab.com:27345/router_integration?connectTimeoutMS=1000",
                "routing_rules")
    }

    @Bean
    open fun routingService(): RoutingService {
        return RoutingService(routingRuleRepository())
    }
}