package com.richard.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonProcessorService implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        Person person = exchange.getIn().getBody(Person.class);

        //Thread.sleep(100);

        log.info("processing queue, id: {} personName: {} ", person.getId(), person.getName());
    }
}
