package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleRepository {

    @PersistenceContext
    private EntityManager em;

    public void createRole(Role role){
        em.persist(role);
    }
}
