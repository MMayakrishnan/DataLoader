package com.hotel.dataloader.config;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.hotel.dataloader.pojo.Amenities;
import com.hotel.dataloader.pojo.Room;
import com.hotel.dataloader.pojo.RoomType;
import com.hotel.dataloader.pojo.User;
import com.hotel.dataloader.repository.AmenitiesRepository;
import com.hotel.dataloader.repository.RoomRepository;
import com.hotel.dataloader.repository.RoomTypeRepository;
import com.hotel.dataloader.repository.UserRepository;



@Component
public class InitializeRoomData {

	@Autowired
	RoomTypeRepository roomTypeRepository;
	
	@Autowired
	AmenitiesRepository amenetiesRepository;
	
	@Autowired
	RoomRepository roomRepository;

	@Autowired
	UserRepository userRepository;
	
	@PostConstruct
	public void initaizeRoomInfo() {
		RoomType deluxeRoom=new RoomType("DELUXE", new BigDecimal(1000.25));
		RoomType luxuryRoom=new RoomType("LUXURY",new BigDecimal(1500.75));
		RoomType suiteRoom=new RoomType("SUITE",new BigDecimal(2250));
		
		
		Amenities fan=new Amenities("Fan"); 
		Amenities ac=new Amenities("A/C");
		Amenities tv=new Amenities("TV");
		Amenities heater=new Amenities("Heater");
		Amenities bathTub=new Amenities("BathTub");
		Amenities balcony=new Amenities("Balcony");
		Amenities livingRoom=new Amenities("Living Room");
		
		Set<Amenities> basicAmenties=new HashSet<>();
		basicAmenties.add(fan);
		basicAmenties.add(heater);
		basicAmenties.add(tv);
		
		Set<Amenities> luxuryAmenties=new HashSet<>();
		luxuryAmenties.addAll(basicAmenties);
		luxuryAmenties.add(ac);
		luxuryAmenties.add(bathTub);
		
		Set<Amenities> suiteAmenties=new HashSet<>();
		suiteAmenties.addAll(luxuryAmenties);
		suiteAmenties.add(livingRoom);
		suiteAmenties.add(balcony);
		
		suiteRoom.setAmenities(suiteAmenties);
		luxuryRoom.setAmenities(luxuryAmenties);
		deluxeRoom.setAmenities(basicAmenties);
		
		List<RoomType> roomTypes=new ArrayList<>();
		roomTypes.add(deluxeRoom);
		roomTypes.add(suiteRoom);
		roomTypes.add(luxuryRoom);

		roomTypeRepository.saveAll(roomTypes);
		
		Room room1=new Room(deluxeRoom);
		Room room2=new Room(deluxeRoom);
		Room room3=new Room(luxuryRoom);
		Room room4=new Room(suiteRoom);
		Room room5=new Room(suiteRoom);
		Room room6=new Room(suiteRoom);
		Room room7=new Room(suiteRoom);
		Room room8=new Room(luxuryRoom);
		Room room9=new Room(luxuryRoom);
		List<Room> rooms=new ArrayList<>();
		
		rooms.add(room9);
		rooms.add(room8);
		rooms.add(room7);
		rooms.add(room6);
		rooms.add(room5);
		rooms.add(room3);
		rooms.add(room4);
		rooms.add(room2);
		rooms.add(room1);
		
		roomRepository.saveAll(rooms);
		
		
		User user=new User("Admin",Base64.getEncoder().encodeToString("admin".getBytes()),"admin@gmail.com","admin");
		User user2=new User("User",Base64.getEncoder().encodeToString("user".getBytes()),"user@gmail.com","user");
		userRepository.save(user);
		userRepository.save(user2);
		
	}
}
