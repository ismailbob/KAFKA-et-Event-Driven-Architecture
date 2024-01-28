package com.sid.demospringcloudstreamskafka.services;

import com.sid.demospringcloudstreamskafka.entities.PageEvent;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Configuration
public class pageEventService {
    @Bean
    public Consumer<PageEvent> pageEventConsumer(){
        return (input)->{
            System.out.println("*****************************");
            System.out.println(input.toString());
            System.out.println("*****************************");
        };
    }



    @Bean
    public Supplier<PageEvent> pageEventSupplier(){
        return ()->new PageEvent(Math.random()>0.5?"Baouab":"Baouab1",Math.random()>0.5?"Ismail":"Ismail1",new Date(), new Random().nextInt(9000));
    }

    @Bean
    public Function<PageEvent, PageEvent> PageEventFunction(){
        return (input)->{
            input.setName("L:"+input.getName().length());
            input.setUser("UUUUU");
            return input;
        };
    }

}
