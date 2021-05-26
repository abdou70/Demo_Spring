package com.example.demo.dao;

import com.example.demo.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormation  extends JpaRepository<Formation, Integer> {
}
