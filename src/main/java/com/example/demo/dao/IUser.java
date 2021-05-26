package com.example.demo.dao;


import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser  extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE u.email=:em AND u.password=:pw")
    public User getUserByEmailAndPassword(@Param("em") String email,@Param("pw") String password);
}
