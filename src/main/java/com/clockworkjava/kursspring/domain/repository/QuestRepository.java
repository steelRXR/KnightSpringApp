package com.clockworkjava.kursspring.domain.repository;

import com.clockworkjava.kursspring.domain.Quest;
import com.clockworkjava.kursspring.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Repository
public class QuestRepository {

    @PersistenceContext
    private EntityManager em;

    Random rand = new Random();

    @Transactional
    public void createQuest(String description) {
        Quest newQuest = new Quest(description);
        em.persist(newQuest);
    }

    public List<Quest> getAll() {
        return em.createQuery("from Quest", Quest.class).getResultList();
    }

    public void deleteQuest(Quest quest) {
      em.remove(quest);
    }

    @Scheduled(fixedDelayString  = "${questCreationDelay}")
    @Transactional
    public void createRandomQuest() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Uratuj ksiezniczke");
        descriptions.add("Wez udzial w turnieju");
        descriptions.add("Zabij bande goblinow");
        descriptions.add("Zabij smoka");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        createQuest(description);
    }

    @Transactional
    public void update(Quest quest) {
        em.merge(quest);
    }

    public Quest getQuest(Integer id) {
        return em.find(Quest.class,id);
    }

}
