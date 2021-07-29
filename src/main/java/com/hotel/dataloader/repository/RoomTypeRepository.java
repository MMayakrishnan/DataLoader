package com.hotel.dataloader.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.dataloader.pojo.RoomType;


@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

	Optional<RoomType> findByRoomType(String roomType);


	Optional<List<RoomType>> findByAmenities_AmenitiesInfoIgnoreCase(String facility);
	
}
