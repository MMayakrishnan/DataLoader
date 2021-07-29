package com.hotel.dataloader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.dataloader.pojo.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{


}
