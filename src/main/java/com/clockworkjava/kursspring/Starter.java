package com.clockworkjava.kursspring;

import com.clockworkjava.kursspring.domain.PlayerInformation;
import com.clockworkjava.kursspring.domain.Role;
import com.clockworkjava.kursspring.domain.repository.KnightRepository;
import com.clockworkjava.kursspring.domain.repository.PlayerInformationRepository;
import com.clockworkjava.kursspring.domain.repository.QuestRepository;
import com.clockworkjava.kursspring.domain.repository.RoleRepository;
import com.clockworkjava.kursspring.services.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    QuestRepository questRepository;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformationRepository playerInformationRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {

//        questRepository.createRandomQuest();
//        questRepository.createRandomQuest();
//
//        knightRepository.createKnight("Arthur",33);
//        knightRepository.createKnight("Percival",27);
//        knightRepository.createKnight("Gruby",22);
//        questService.assignRandomQuest("Arthur");
//        questService.assignRandomQuest("Percival");
//
//        PlayerInformation pI = new PlayerInformation("user1","user1");
//        PlayerInformation pI2 = new PlayerInformation("user2","user2");
//        playerInformationRepository.createPlayerInformation(pI);
//        playerInformationRepository.createPlayerInformation(pI2);
//
//        Role role = new Role("user1","ADMIN");
//        Role role2 = new Role("user1","USER");
//        Role role3 = new Role("user2","USER");
//
//        roleRepository.createRole(role);
//        roleRepository.createRole(role2);
//        roleRepository.createRole(role3);


    }

}
