package com.baeldung.reactiveapp.server.functional.routers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.baeldung.reactiveapp.server.functional.handlers.ReactiveHandler;

@Configuration
public class ReactiveRouter {

    @Bean
    public RouterFunction<ServerResponse> responseRoute(@Autowired ReactiveHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/functional-reactive/periodic-foo"), handler::useHandler);
    }
}
