package com.hotel.dataloader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.dataloader.pojo.Amenities;


public interface AmenitiesRepository extends JpaRepository<Amenities, Integer> {

}
