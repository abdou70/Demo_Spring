package com.example.demo.dao;

import com.example.demo.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoles  extends JpaRepository<Roles, Integer> {
}
