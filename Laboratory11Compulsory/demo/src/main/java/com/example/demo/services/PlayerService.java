package com.example.demo.services;

import com.example.demo.entities.Player;
import com.example.demo.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;
    public List<Player> findAllPlayers(){
        List<Player> playerList = new ArrayList<>();
        try{
            playerList = this.playerRepository.findAll();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return playerList;
    }
}
