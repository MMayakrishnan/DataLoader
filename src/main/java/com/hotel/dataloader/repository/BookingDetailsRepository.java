package com.hotel.dataloader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.dataloader.pojo.BookingDetails;



@Repository
public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Integer>{
}

//
//select roomNo, roomType.roomTypeid
//from rooms 
//where roomNo not in 
//(
//  select roomNo 
//  from booking 
//  where departure >= to_date(? /* desired arrival date */, 'yyyy-mm-dd')
//  and arrival <= to_date(? /* desired departure date */, 'yyyy-mm-dd')
//)
//and roomType.roomTypeid = ? /* desired room type */
//order by roomNo;