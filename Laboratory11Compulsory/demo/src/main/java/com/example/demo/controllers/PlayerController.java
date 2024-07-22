package com.example.demo.controllers;

import com.example.demo.entities.Player;
import com.example.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;
    private List<Player> playerList;

    public PlayerController() {
        this.playerList = new ArrayList<>();
    }

    @GetMapping("/players")
    public List<Player> getPlayers() {
        return this.playerService.findAllPlayers();
    }

    @GetMapping("/players/count")
    public int countPlayers() {
        return this.playerService.findAllPlayers().size();
    }

    @GetMapping("players/{id}")
    public Player getPlayer(@PathVariable("id") int id) {
        return this.playerService.findAllPlayers().stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
