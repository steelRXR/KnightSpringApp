package com.clockworkjava.kursspring.domain.repository.repositoryImpl;

import com.clockworkjava.kursspring.domain.Knight;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements KnightRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    @Override
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name,age);
        em.persist(knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
      return em.createQuery("from Knight",Knight.class).getResultList();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
       Knight knight = em.createQuery("from Knight k where k.name=:name",Knight.class)
               .setParameter("name", name)
               .getSingleResult();

       return Optional.ofNullable(knight);
    }

    @Transactional
    @Override
    public void deleteKnight(Knight knight) {
       em.remove(knight);
    }

    @Override
    @PostConstruct
    public void build() {

    }

    @Transactional
    @Override
    public void createKnight(Knight knight) {
        em.persist(knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return em.find(Knight.class,id);
    }

    @Transactional
    public void update(Knight knight){
        em.merge(knight);
    }


}
