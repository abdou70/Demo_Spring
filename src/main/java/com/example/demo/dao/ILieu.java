package com.example.demo.dao;


import com.example.demo.entities.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILieu  extends JpaRepository<Lieu,Integer> {
}
