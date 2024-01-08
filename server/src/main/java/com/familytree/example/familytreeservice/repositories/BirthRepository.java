package com.familytree.example.familytreeservice.repositories;

import com.familytree.example.familytreeservice.models.Event.Birth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthRepository extends JpaRepository<Birth, Long> {
}
