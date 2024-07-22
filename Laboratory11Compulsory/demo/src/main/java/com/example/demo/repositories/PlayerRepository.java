package com.example.demo.repositories;

import com.example.demo.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findAll();
}
