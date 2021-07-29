package com.hotel.dataloader.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotel.dataloader.pojo.Room;


public interface RoomRepository extends JpaRepository<Room, Integer>{
	@Query("select r.roomNo,r.roomType.roomType from Room r where r.roomNo not in ( select r.roomNo from BookingDetails b where b.departure=to_date(?1) and b.arrival=to_date(?2))")
	public Optional<List<Room>> getAvailableRooms(Date arrival, Date depature);

	@Query("select r.roomNo,r.roomType.roomType from Room r where r.roomNo not in ( select r.roomNo from BookingDetails b where b.departure=to_date(?1) and b.arrival=to_date(?2)) and r.roomType.roomTypeId=(select r.roomType.roomTypeId from r.roomType.roomType where r.roomType.roomType=?3)")
	public Optional<List<Room>> getAvailableRooms(Date arrival, Date depature, String roomType); 
}
