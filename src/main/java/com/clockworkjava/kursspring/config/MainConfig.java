package com.clockworkjava.kursspring.config;

import com.clockworkjava.kursspring.domain.repository.repositoryImpl.DBKnightRepository;
import com.clockworkjava.kursspring.domain.repository.repositoryImpl.InMemoryRepository;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.context.annotation.*;

@Configuration
public class MainConfig {


    @Bean(name="inMemoryKnighRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo() {
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name="DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBRepo() {
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }

}
