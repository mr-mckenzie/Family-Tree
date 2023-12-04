package com.familytree.example.familytreeservice.repositories;

import com.familytree.example.familytreeservice.models.Ancestor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AncestorRepository extends JpaRepository <Ancestor, Long> {
}
