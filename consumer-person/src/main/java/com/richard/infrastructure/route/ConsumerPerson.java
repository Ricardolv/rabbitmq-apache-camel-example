package com.richard.infrastructure.route;

import com.richard.domain.Person;
import com.richard.domain.PersonProcessorService;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumerPerson extends RouteBuilder {

    private final PersonProcessorService personProcessorService;

    @Override
    public void configure() throws Exception {
        from("{{application.rabbitmq.queues.person}}")
                .unmarshal()
                .json(JsonLibrary.Jackson, Person.class)
                .process(personProcessorService);
    }
}
