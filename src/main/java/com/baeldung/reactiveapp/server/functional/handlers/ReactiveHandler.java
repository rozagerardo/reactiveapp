package com.baeldung.reactiveapp.server.functional.handlers;

import java.time.Duration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.baeldung.reactiveapp.server.model.Foo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactiveHandler {

    public Mono<ServerResponse> useHandler(final ServerRequest request) {
        return ServerResponse.ok()
            .body(Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> new Foo("name", String.valueOf(sequence))), Foo.class);
    }
    
}
