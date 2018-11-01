package com.baeldung.reactiveapp.server.controllers;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.reactiveapp.server.model.Foo;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/reactive-controller")
public class ReactiveRestController {

    @GetMapping(value = "/periodic-foo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Foo> periodicFooEndpoint() {
        return Flux.interval(Duration.ofSeconds(1))
            .map(sequence -> new Foo("aFooName", String.valueOf(sequence)));
    }

}
