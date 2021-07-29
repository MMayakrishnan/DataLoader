package com.hotel.dataloader.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomNo;
	@ManyToOne
	@JoinColumn(name="roomTypeId")
	private RoomType roomType;
	public Room(RoomType roomType) {
		super();
		this.roomType = roomType;
	}
	
	

}