package com.familytree.example.familytreeservice.repositories;

import com.familytree.example.familytreeservice.models.Event.Death;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeathRepository extends JpaRepository<Death, Long> {
}
